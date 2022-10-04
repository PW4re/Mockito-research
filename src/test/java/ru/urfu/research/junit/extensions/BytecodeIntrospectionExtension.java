package ru.urfu.research.junit.extensions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

import net.bytebuddy.agent.ByteBuddyAgent;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class BytecodeIntrospectionExtension implements BeforeAllCallback {

    private final static String resultDirectoryName = "result/";

    @Override
    public void beforeAll(ExtensionContext context) {
        var dir = new File(resultDirectoryName);
        if (!dir.mkdir()) {
            // clear directory
            recursiveRemoveContent(dir);
        }

        ByteBuddyAgent.install();
        var instrumentation = ByteBuddyAgent.getInstrumentation();
        instrumentation.addTransformer(new ClassFileTransformer() {
            @Override
            public byte[] transform(ClassLoader loader,
                                    String className,
                                    Class<?> classBeingRedefined,
                                    ProtectionDomain protectionDomain,
                                    byte[] classfileBuffer) {
                if (className.startsWith("ru/urfu/research/example/")) {
                    System.out.printf("Class loader: %s  Class: %s%n", loader, className);
                    var fileName = className.substring(className.lastIndexOf('/') + 1);
                    try (var out = createOutputStreamToFile(fileName)) {
                        out.write(classfileBuffer);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                return classfileBuffer;
            }
        });
    }

    private static OutputStream createOutputStreamToFile(String fileName) {
        try {
            var file = new File(resultDirectoryName + fileName + ".class");
            file.createNewFile();
            return new FileOutputStream(file);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return OutputStream.nullOutputStream();
    }

    private static void recursiveRemoveContent(File dir) {
        var files = dir.listFiles();
        if (files == null || files.length == 0) {
            return;
        }
        for (File f : files) {
            if (f.isDirectory()) {
                recursiveRemoveContent(f);
            } else {
                f.delete();
            }
        }
    }

}
