package Date;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import Button.*;

public class DateCalendar {
    public JComboBox calendar(){
        JComboBox Date;
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd" );
        String[] days=new String[31];
        Calendar d= Calendar.getInstance();
        String str=sdf.format(d.getTime());
        int len=Integer.valueOf(str.substring(8,10));
        dataModify.newData=len;
        d.add(Calendar.DATE,-1*len);
        for(int i=0;i<len;i++){
            d.add(Calendar.DATE,1);
            days[len-i-1]=sdf.format(d.getTime());
        }
        Date = new JComboBox(days);
        Date.setBounds(50, 50, 40, 30);
        return Date;
    }
}
