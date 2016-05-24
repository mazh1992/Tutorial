package com.rsa.utils;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

/**
 * Created by mazhenhua on 2016/5/24.
 */
public class RSATest {


   /* public static final String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAOmMyROlH4suUfB0\n" +
            "QUleJtwH3wEJ0vI+Mg6lNxFOsyvcVRGliVzbQ3XoOAtYBL6/+exzztTmHZ6pUY5u\n" +
            "QRhFGC3hKwQm+XXvli4w7NI5N6NiIyeSmqH1FzUZuF/cf9AwFb84nddT6MQ95kqT\n" +
            "MzB1cei2n8O26G54GvEAH0TBI1ERAgMBAAECgYEAgDrzYBzmX9Wz2ZELE4xlS6Pq\n" +
            "tjg9oRGzDEV8Ib2TNH7KGmFINTqSJJe2xcuy90SSpVfEdTJPiwCuLcStavTs258l\n" +
            "J6rdLPSis706pYerlrw1NJXxzRQcu3zfcz/cga4ZaaqohX86yrkbTIgs0Ue0+dKM\n" +
            "uo7gbanxpq1xh+jGIxECQQD/bLNJd4m+D2EIhTt47JsmhtflEcCY+MG7n7HmAgjC\n" +
            "k05vGU8hHl3mrJN2xNnEAPAuZcaup4tiuAP8zKuDGb9tAkEA6hN4ZnZR+XPnFy9U\n" +
            "UF/f6qX5YqjEZ5FGISPbAmyNED7KbdM3ix1eet5pJbaBLVEPBGmtCjlpurely+Rv\n" +
            "hVo9tQJAKzHrw/HWNnENXM6DNzj0J/jHy/JLmtL+mEcyY45Wguk8a2dhTV2ATcFD\n" +
            "kuNJXG84LvCBQAoPdVtfOUI3gw04pQJBANZGVowtOeNJxzzBFcSxz0+E+iLnbUuF\n" +
            "gBYsNXsllYhOgo5AsPLHQsrlOInOZLfwIPggKMhYQEIthTd9eN0w+5UCQDlOtbTw\n" +
            "Vxa9PpbN2trYorLVGIFq4k09QqnGeeJ+o4Z3bldqJyaXasUF7+v3srHbQiSzZwxd\n" +
            "x/AhGRpsAo4ZJss=";


    public static final String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDpjMkTpR+LLlHwdEFJXibcB98B\n" +
            "CdLyPjIOpTcRTrMr3FURpYlc20N16DgLWAS+v/nsc87U5h2eqVGObkEYRRgt4SsE\n" +
            "Jvl175YuMOzSOTejYiMnkpqh9Rc1Gbhf3H/QMBW/OJ3XU+jEPeZKkzMwdXHotp/D\n" +
            "tuhueBrxAB9EwSNREQIDAQAB";*/

    public static final String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCxlgvy2+OyZXhb\n" +
            "hypi5sPcTN8LOliC+hJfcgjJO1uUZeji9k/qLBG/Xde7v6cTkoezO36iuJt7VNGl\n" +
            "Q/Ir+RM1o98nwSR1MQxR6bhQqOP71Xw7oQ67Agtz3f6M0thVKaHT0/AVmbl0VXdc\n" +
            "dmzll3NePHrBElJtVL36xyTdmhQe8+dQbbRYdRfD4bLxEh/bPVvvULQ0ZpKuuAzU\n" +
            "Ya8ouPz/kIT9NlQd5tT3q5efC/Dm9MYvN9+PuubYNw61DMpvrOMIJi0pzpYyQRgQ\n" +
            "Z6rIc0v+HWuvxT5n8S+qnVoi25YG71U5EnKq4AV2xya+kCNdrJymE7WPUYg3Z/Sn\n" +
            "fgsvJE4HAgMBAAECggEAcn2WPoDdj8ozim7eON0mMQWuVwLKxcaLydUvLO2D4WzC\n" +
            "dHDwnLzExGewCm9JPCkgK8GTpzz1oNHSR4ZCv27Zn5+C45J1+sggdT8FgZshQN8m\n" +
            "NRtk79QlphHdZtUYe+9XUcY15vcwxXvEdGw1UOAPlRXQ3mD9m1cjFGcHsYcAqeLp\n" +
            "5gzeQsBKFEpW1mTlSRj5NCavHSaa+6fsT3bJjTz6FUjGts8Sq2fTcKxC/2Qzexl5\n" +
            "bWQag0uv2RT29Hr/tlReLSmyJPvxDOs/UInL4GsplXdoKyNusyP5oYn0VW0/yoa2\n" +
            "zJDXNMEpD7rbJlirPud879YUWfpoU5aYOK7D1iPpwQKBgQDmMmpndYj0NXgELhjN\n" +
            "aqbkF464xVpPa2Dg4oMbeGRIb4SlYz9s5E969rPDbhmtFNvPjyBLU16WGkSHWVvT\n" +
            "PQk4hzOtTXOGfgdODdlB25/KmPYMwShnKXwGp3VPH3zwDkWV3/KVJAn9NtSrJyIf\n" +
            "JfKwIrMMLkPId4j2hTk5H+gbGQKBgQDFffHTGupQ8insmzR7oM2EcD+Zc1PBvBB6\n" +
            "D0XKN/Y9Qvv5lZ2P46k+kO3SU8DhNeTH9F/AyMrPdwd+BMuGzz+3MaAHtX5WAY8+\n" +
            "AKjAWn9xyJxF7giOf15TXevIOUjBmelCwfIDWUViLrda147exr9zVu+BOHFFOgyI\n" +
            "ThfDdtf2HwKBgEnsassqrX5vJUmCXCirVUjuX8Dqb6QNgaD2XNAXi2zPkzNhed7I\n" +
            "OtXsH7Jkyw4QIr624dIOxdNCQDuO8LQXZ7ylfmzq8GyCUGo6fEhv9RKkqG9UIFtw\n" +
            "sQmaAUwVepPEoYgN0OMgHa0ZTJZiDM0f7J2vpvwEZ3QbHvq7sbKskmcRAoGBAIuI\n" +
            "CzYKmyhroAFCOtdp6io7IEQrfi6vz7hdWAKifUAVNm/FLFhAEhBZVx21/N1hNW2s\n" +
            "k4Zilx/zSgDYJG/vt2WYEye/LC5Z1bmJv7B/f/GFOhwSLEt5Y8xk3DRPfL8EHhED\n" +
            "dBi3ltTiirsM9y0goJ09++OBXE370GTxP8rjCXwjAoGAU0E9ePqo+j4HDez5u9Xa\n" +
            "BYC/hu0JGHyzw8RBLmIR3sfGQ1l3MsQHF94bz6WiLyVFquiFmfxaISKU0jHy8Pcf\n" +
            "sIjXP/nPqgO1g7RuM6uXgJ/M56LXay2oydBFrEiLTy5RYXFBinuLSy7j8rLviH2W\n" +
            "BK+Dy/WiNSHWEKIF5RdDpxo=";

    public static final String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsZYL8tvjsmV4W4cqYubD\n" +
            "3EzfCzpYgvoSX3IIyTtblGXo4vZP6iwRv13Xu7+nE5KHszt+oribe1TRpUPyK/kT\n" +
            "NaPfJ8EkdTEMUem4UKjj+9V8O6EOuwILc93+jNLYVSmh09PwFZm5dFV3XHZs5Zdz\n" +
            "Xjx6wRJSbVS9+sck3ZoUHvPnUG20WHUXw+Gy8RIf2z1b71C0NGaSrrgM1GGvKLj8\n" +
            "/5CE/TZUHebU96uXnwvw5vTGLzffj7rm2DcOtQzKb6zjCCYtKc6WMkEYEGeqyHNL\n" +
            "/h1rr8U+Z/Evqp1aItuWBu9VORJyquAFdscmvpAjXaycphO1j1GIN2f0p34LLyRO\n" +
            "BwIDAQAB";




    public static void main(String[] args) throws Exception {
        String testString = "这是一行没有任何意义的文字，你看完了等于没看，不是吗？";

        // 1、测试加签
        System.out.println("=================加签测试START===================");
        System.out.println("加签原文：" + testString);
        String signResult = RSA.sign(testString, privateKey, "utf-8");
        System.out.println("加签后的值：" + signResult);
        System.out.println("=================加签测试END===================");

        // 2、测试验签
        System.out.println("=================验签测试START===================");
        System.out.println("验签原文：" + testString);
        boolean verify = RSA.verify(testString, signResult, publicKey, "utf-8");
        System.out.println("验签结果：" + verify);
        System.out.println("=================验签测试END===================");

        // 3、测试加密（公钥加密）
        System.out.println("=================加密测试START===================");
        System.out.println("加密前：" + testString);
        byte[] data = testString.getBytes("utf-8");
        byte[] encodedData = RSA.encryptByPublicKey(data, publicKey);
        System.out.println("加密后" + Base64.encodeBase64String(encodedData));
        System.out.println("=================加密测试END===================");

        // 4、测试解密（私钥解密）
        System.out.println("=================解密测试START===================");
        System.out.println("解密前" + Base64.encodeBase64String(encodedData));
        byte[] decodedData = RSA.decryptByPrivateKey(encodedData, privateKey);
        System.out.println("解密后" + new String(decodedData));
        System.out.println("=================解密测试END===================");

    }
}
