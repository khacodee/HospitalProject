/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import static java.lang.Integer.parseInt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author NhiLamHet
 */
public class MyTool {

    public static final Scanner sc = new Scanner(System.in);

    public static String convertDateFormat(Date d) {
        SimpleDateFormat DateFor = new SimpleDateFormat("dd-MM-yyyy");
        if (d != null) {
            return DateFor.format(d);
        }
        return null;
    }

    public static int getAnInteger(String inputMsg, String errorMsg, boolean allowBlank) {
        int number = 0;
        do {
            try {
                System.out.print(inputMsg);
                String input = sc.nextLine();
                if (input.isEmpty()) {
                    if (allowBlank) {
                        return 0;
                    }
                }
                number = parseInt(input);
                return number;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        } while (true);
    }

    //input integer in range min...max
    public static int getAnInteger(String inputMsg, String errorMsg, int lowerBound, int upperBound) {
        int n, tmp;
        if (lowerBound > upperBound) {
            tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n < lowerBound || n > upperBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static double getADouble(String inputMsg, String errorMsg, double lowerBound, double upperBound) {
        double n, tmp;
        if (lowerBound > upperBound) {
            tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                if (n < lowerBound || n > upperBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    //Regular Expression
    public static String getID(String inputMsg, String errorMsg, String format) {
        String id;
        boolean match;
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine().trim().toUpperCase();
            match = id.matches(format);
            if (id.length() == 0 || id.isEmpty() || match == false) {
                System.out.println(errorMsg);
            } else {
                return id;
            }
        }
    }

    public static String getString(String inputMsg, String errorMsg, boolean allowBlank) {
        String str;
        while (true) {
            System.out.print(inputMsg);
            str = sc.nextLine().trim();
            if (str.length() == 0 || str.isEmpty()) {
                if (allowBlank) {
                    return "";
                } else {
                    System.out.println(errorMsg);
                }

            } else {
                return str;
            }
        }
    }

    public static Boolean getBoolean(String inputMsg, String errorMsg, boolean allowBlank) {
        Boolean result;
        do {
            try {
                String input = getString(inputMsg, errorMsg, allowBlank);
                if (input.isEmpty() && allowBlank) {
                    throw new Exception();
                } else if (!input.toUpperCase().equals("N") && !input.toUpperCase().equals("Y")) {
                    throw new Exception();
                }
                result = input.toUpperCase().equals("Y");
                return result;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        } while (true);
    }

    public static String getName(String inputMsg, String errorMsg, String format) {
        String name;
        boolean match;
        while (true) {
            System.out.print(inputMsg);
            name = sc.nextLine().trim().toUpperCase();
            match = name.matches(format);
            if (name.length() == 0 || name.isEmpty() || match == false) {
                System.out.println(errorMsg);
            } else {
                return name;
            }
        }
    }

    public static Boolean getBoolean1(String inputMsg, String errorMsg, boolean allowBlank) {
        Boolean result; //xem lại hàm boolean, nhập khác N vẫn chạy đượcq
        do {
            try {
                String input = getString(inputMsg, errorMsg, allowBlank);
                if (input.isEmpty() && allowBlank) {
                    return null;
                }
                result = input.toLowerCase().equals("y");
                return result;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        } while (true);
    }

    public static Date toDate(String strDate) throws ParseException {
        if (strDate == null) {
            return null;
        }
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        df.setLenient(false);
        return df.parse(strDate);
    }

    public static Date getDate(String inputMsg, String errorMsg) {
        Date date = null;
        do {
            System.out.print(inputMsg);
            try {
                date = toDate(sc.nextLine());
            } catch (ParseException ex) {
                System.out.println(errorMsg);
            }
        } while (date == null);
        return date;

    }

}
