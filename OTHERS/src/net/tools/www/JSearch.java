package net.tools.www;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JSearch {
        private static String path = "";
        private static String filename = ".*\\.(txt|sql)";
        private static String targetStr = "";
        private static String charset = "";
        private static boolean isSearchSubdirectory = false;
        private static String usage = "Usage: java JSearch -t str [-options]\noptions:\n\t -d directory\t Ҫ���ҵ���Ŀ¼��Ĭ���ǵ�ǰĿ¼\n\t -f file\t Ҫ���ҵ��ļ���Ĭ������txt��sql�ļ���֧������\n\t -t targetStr\t ��Ҫ���ҵ�Ŀ���ַ��������ɿգ�֧������\n\t -c charset\t �ַ�����\n\t -r\t\t �ݹ������Ŀ¼\nʾ����\njava JSearch -t t00ls\njava JSearch -t t00ls -d /root/test/txt -f .*\\.txt -c gbk -r";
        
        public static void main(String[] args) {
                if(!parseArgs(args)){
                        return;
                }
                List<File> list = getFiles(path, filename, isSearchSubdirectory);
                find(list);
        }
        
        /**
         * ���ļ��в����ַ��������
         * @param list �ļ��б�
         */
        private static void find(List<File> list) {
                for (File file : list) {
                        String result = find(file.getAbsolutePath());
                        if("".equals(result)){
                                continue;
                        }
                        System.out.println("**********��" + file.getAbsolutePath() + "���ҵ���**********");
                        System.out.println(result);
                }
        }
        
        /**
         * ���ļ��в����ַ���
         * @param filename �ļ�·��
         * @return ���ҽ��
         */
        private static String find(String filename) {
                if(targetStr == null || targetStr.length() == 0) {
                        throw new RuntimeException("Ŀ���ַ�������Ϊ��");
                }
                BufferedReader br = null;
                InputStreamReader isr = null;
                FileInputStream fis = null;
                String line = null;
                String result = "";
                try {
                        fis = new FileInputStream(filename);
                        isr = "".equals(charset) ? new InputStreamReader(fis) : new InputStreamReader(fis, charset);
                        br = new BufferedReader(isr);
                        
                        Pattern pattern = Pattern.compile(targetStr);
                        
                        while((line = br.readLine()) != null){
                                Matcher matcher = pattern.matcher(line);
                                if(matcher.find()){
                                        result += line + "\n";
                                }
                        }
                } catch (FileNotFoundException e) {
                        e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                        System.out.println("������Ч");
                        e.printStackTrace();
                } catch (IOException e) {
                        e.printStackTrace();
                } finally {
                        if(fis != null){
                                try {
                                        fis.close();
                                } catch (IOException e) {
                                        e.printStackTrace();
                                }
                        }
                        if(isr != null){
                                try {
                                        isr.close();
                                } catch (IOException e) {
                                        e.printStackTrace();
                                }
                        }
                        if(br != null){
                                try {
                                        br.close();
                                } catch (IOException e) {
                                        e.printStackTrace();
                                }
                        }
                }
                return result;
        }

        /**
         * ��ȡĳһ·���µ����з����������ļ�
         * @param path ·��
         * @param filename �ļ�����������
         * @param isSearchSubdirectory �Ƿ������Ŀ¼
         * @return �ļ��б�
         */
        private static List<File> getFiles(String path, final String filename, boolean isSearchSubdirectory) {
                List<File> result = new ArrayList<File>();
                File file = new File(path).getAbsoluteFile();
                if(!file.exists()){
                        return result;
                }
                if(file.isFile()){
                        result.add(file);
                        return result;
                }
                
                File[] files = file.listFiles(new FileFilter() {
                        
                        @Override
                        public boolean accept(File file) {
                                if(!file.getAbsoluteFile().isDirectory()){
                                        if("".equals(filename)){
                                                return true;
                                        }
                                        if(file.getAbsoluteFile().getName().matches(filename)){
                                                return true;
                                        }
                                }
                                return false;
                        }
                        
                });
                result.addAll(Arrays.asList(files));
                
                if(isSearchSubdirectory){
                        File[] directorys = file.listFiles(new FileFilter() {
                                
                                @Override
                                public boolean accept(File file) {
                                        if(file.getAbsoluteFile().isDirectory()){
                                                return true;
                                        }
                                        return false;
                                }
                                
                        });
                        
                        for (File directory : directorys) {
                                List<File> list = getFiles(directory.getAbsolutePath(), filename, isSearchSubdirectory);
                                result.addAll(list);
                        }
                }
                
                return result;
        }

        /**
         * ��������
         * @param args ��������
         * @return �����Ƿ�ɹ�
         */
        private static boolean parseArgs(String[] args) {
                if(args.length == 0){
                        System.out.println(usage);
                        return false;
                }
                try {
                        for (int i = 0; i < args.length; i++) {
                                if("-d".equals(args[i])){
                                        path = args[i + 1];
                                }
                                if("-f".equals(args[i])){
                                        filename = args[i + 1];
                                }
                                if("-t".equals(args[i])){
                                        targetStr = args[i + 1];
                                }
                                if("-c".equals(args[i])){
                                        charset = args[i + 1];
                                }
                                if("-r".equals(args[i])){
                                        isSearchSubdirectory = true;
                                }
                        }
                        if("".equals(targetStr)){
                                System.out.println("����-t����ָ��Ҫ���ҵ��ַ���");
                                return false;
                        }
                        return true;
                } catch (Exception e) {
                        System.out.println(usage);
                        return false;
                }
        }
}