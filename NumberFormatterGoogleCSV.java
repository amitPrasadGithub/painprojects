import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class NumberFormatterGoogleCSV {
    static Set<String> set = new LinkedHashSet<>();

    public static void main(String[] args) {
        readFile("/path/to/folder");
    }

    public static File readFile(String path) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("out.csv"));
            File file = new File(path);
            String[] list = file.list();
            for(String f:list) {
                writer = parseFile(new File(path, f), writer);
            }
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static BufferedWriter parseFile(File input, BufferedWriter writer) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(input));
            String line = "";
            boolean isHeader = true;
            while ((line = reader.readLine()) != null) {
                writer =   isHeader?parseLine(line, true, writer):parseLine(line, false, writer);
                isHeader = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return writer;
    }

    public static BufferedWriter parseLine(String str, boolean isHeader, BufferedWriter writer) {
        if(isHeader) {
            try {
                writer.write(str+"\n");
                return writer;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String[] ar = str.split(",");
        List<String> list = Arrays.asList(ar);
        Set<String> m_set = new LinkedHashSet<>();

        List n_list = list.stream().map(
                e -> {
                    boolean isNumber = true;

                    if(e.contains(":::")) {
                        String[] n1_str = e.split(":::");
                        for(String s1:n1_str) {
                            if(s1.contains(" ")) {
                                String[] n_str = s1.split(" ");
                                try {
                                    for(String s:n_str) {
                                        if(s.length() != 0) {
                                            long l1 = Long.valueOf(s.trim());
                                        }
                                    }
                                } catch (Exception e2) {
                                    isNumber = false;
                                    break;
                                }
                            }
                        }

                    }

                    else if(e.contains(" ") && !e.contains(":::")) {
                        String[] n_str = e.split(" ");
                        try {
                            for(String s:n_str) {
                                long l = Long.valueOf(s);
                            }
                        } catch (Exception e2) {
                            isNumber = false;
                        }
                    } else {
                        try {
                            long l = Long.valueOf(e);
                        } catch (Exception e3) {
                            isNumber = false;
                        }
                    }
                    if(!isNumber) {
                        return e;
                    } else {
                        m_set.add(e.replaceAll(" ", ""));
                        return e.replaceAll(" ", "");
                    }
                }
        ).collect(Collectors.toList());

        if(!set.containsAll(m_set)) {
            set.addAll(m_set);
            try {
                writer.write(listToString(n_list)+"\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return writer;
    }

    public static String listToString(List<String> list) {
        String str = list.toString();
        return str.substring(1, str.length()-1);
    }
}
