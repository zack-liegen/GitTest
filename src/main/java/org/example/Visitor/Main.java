package org.example.Visitor;


import java.io.File;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        FileStructure fs = new FileStructure(new File("E:\\work file\\newDemo\\demo"));
        fs.handle(new JavaFileVisitor());
        System.out.println("-------------------");
        fs.handle(new XmlFileCleanerVisitor());
    }
}

// 访问者接口，定义访问者的能力
interface Visitor {
    // 访问文件夹:
    void visitDir(File dir);
    // 访问文件:
    void visitFile(File file);
}
// 定义文件数据结构
class FileStructure {
    // 根目录:
    private File path;
    public FileStructure(File path) {
        this.path = path;
    }
    // 用handle传入访问者
    public void handle(Visitor visitor) {
        scan(this.path, visitor);
    }
    // 递归访问文件
    private void scan(File file, Visitor visitor) {
        if (file.isDirectory()) {
            // 让访问者处理文件夹:
            visitor.visitDir(file);
            for (File sub : Objects.requireNonNull(file.listFiles())) {
                // 递归处理子文件夹:
                scan(sub, visitor);
            }
        } else if (file.isFile()) {
            // 让访问者处理文件:
            visitor.visitFile(file);
        }
    }
}
// 具体的访问者
class JavaFileVisitor implements Visitor {
    public void visitDir(File dir) {
//        System.out.println("Visit dir: " + dir);
    }

    public void visitFile(File file) {
        if (file.getName().endsWith(".java")) {
            System.out.println("Found java file: " + file);
        }
    }
}
// 另一个具体的访问者
class XmlFileCleanerVisitor implements Visitor {
    public void visitDir(File dir) {
    }
    public void visitFile(File file) {
        if (file.getName().endsWith(".xml")) {
            System.out.println("Will clean class file: " + file);
        }
    }
}

