package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static java.nio.file.StandardOpenOption.*;

public class ZipForCodeCheckUpload {

    public static void main(String[] args) throws IOException {
        String mainPackageRoot = args[0];
        String packageName = args[1];
        final Path tmpDir = Path.of("/tmp", packageName);
        List<String> fileNames = new ArrayList<>();
        try {
            Files.createDirectory(tmpDir);
        } catch (FileAlreadyExistsException e) {
        }
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Path.of(mainPackageRoot, packageName))) {
            for (Path entry: stream) {
                List<String> lines = Files.readAllLines(entry);
                if (entry.toString().endsWith(".java")) {
                    lines.remove(0);  //package declaration
                    lines.remove(0);  //package declaration
                }
                final String fileName = entry.getFileName().toString();
                Files.write(Path.of(tmpDir.toString(), fileName), lines, CREATE, WRITE, TRUNCATE_EXISTING);
                fileNames.add(fileName);
            }
        }
        String testPackageRoot = mainPackageRoot.replace("main","test");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Path.of(testPackageRoot, packageName))) {
            for (Path entry: stream) {
                List<String> lines = Files.readAllLines(entry);
                if (entry.toString().endsWith(".java")) {
                    lines.remove(0);  //package declaration
                    lines.remove(0);  //package declaration
                }
                final String fileName = entry.getFileName().toString();
                Files.write(Path.of(tmpDir.toString(),entry.getFileName().toString()), lines, CREATE, WRITE, TRUNCATE_EXISTING);
                fileNames.add(fileName);
            }
        }

        final FileOutputStream fos = new FileOutputStream("/tmp/" + packageName + ".zip");
        ZipOutputStream zipOut = new ZipOutputStream(fos);

        for (String srcFile : fileNames) {
            File fileToZip = new File(tmpDir + "/" + srcFile);
            FileInputStream fis = new FileInputStream(fileToZip);
            ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
            zipOut.putNextEntry(zipEntry);

            byte[] bytes = new byte[1024];
            int length;
            while((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            fis.close();
        }

        zipOut.close();
        fos.close();
    }
}
