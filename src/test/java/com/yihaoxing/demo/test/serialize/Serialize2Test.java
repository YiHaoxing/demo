package com.yihaoxing.demo.test.serialize;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Serialize2Test {


    @Test
    public void test01() {

        User user = new User();
        user.setAge(10);
        user.setName("abc");
        System.out.println(user);

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(Files.newOutputStream(Paths.get("tempFile")));
            oos.writeObject(user);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            IOUtils.closeQuietly(oos);
        }

        File tempFile = new File("tempFile");

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(Files.newInputStream(tempFile.toPath()));
            User user1 = (User) ois.readObject();
            System.out.println(user1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            IOUtils.closeQuietly(ois);
            try {
                FileUtils.forceDelete(tempFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void test02() {
        User user = new User();
        user.setAge(20);
        user.setName("abc");
        System.out.println(user);

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(Files.newOutputStream(Paths.get("tempFile")));
            oos.writeObject(user);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            IOUtils.closeQuietly(oos);
        }
    }

    @Test
    public void test03() {
        File tempFile = new File("tempFile");

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(Files.newInputStream(tempFile.toPath()));
            User user1 = (User) ois.readObject();
            System.out.println(user1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            IOUtils.closeQuietly(ois);
            try {
                FileUtils.forceDelete(tempFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
