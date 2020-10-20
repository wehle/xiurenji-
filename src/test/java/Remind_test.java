import Remind.Abnormal;
import Remind.LoadPropertyUtils;
import Remind.SendFIle_size;
import org.junit.Test;

public class Remind_test {


    @Test
    public  void Error()
    {



        int a[] = new int[]{1,2};
        try {
            System.out.println(a[2]);
        }catch (Exception e)
        {
            System.out.println(Abnormal.getExceptionDetail(e));
        }

    }

    @Test
    public  void Load()
    {
        System.out.println(LoadPropertyUtils.Getemail("mail.nickname"));
        System.out.println(Remind.LoadPropertyUtils.WordArt());
    }




}
