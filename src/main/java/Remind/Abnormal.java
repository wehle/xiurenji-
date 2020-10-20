package Remind;/*
作者Crying711
日期:10/19/2020
时间:11:51 AM
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;

public class Abnormal {



        public static String getExceptionDetail(Exception ex) {
            String ret = null;
            try {
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                PrintStream pout = new PrintStream(out);
                ex.printStackTrace(pout);
                ret = new String(out.toByteArray());
                pout.close();
                out.close();
            } catch (Exception e) {
            }
            return ret;
        }

        /**
         * 获取异常详细信息，知道出了什么错，错在哪个类的第几行 .
         *
         * @param ex
         * @return
         */
        public static String getExceptionDetail(Error ex) {
            String ret = null;
            try {
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                PrintStream pout = new PrintStream(out);
                ex.printStackTrace(pout);
                ret = new String(out.toByteArray());
                pout.close();
                out.close();
            } catch (Exception e) {
            }
            return ret;
        }

        /**
         * 获取异常详细信息，知道出了什么错，错在哪个类的第几行 .
         *
         * @param
         * @return
         */
        public static String getThrowableDetail(Throwable ex) {
            StringWriter sw = new StringWriter();
            try {
                PrintWriter pw = new PrintWriter(sw, true);
                ex.printStackTrace(pw);
                pw.flush();
                sw.flush();
            } catch (Exception e) {

            }
            return sw.toString();


    }}
