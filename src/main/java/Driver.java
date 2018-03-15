import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

/**
 * Created by ibrahim on 12/4/17.
 */
public class Driver {
    public static void main(String args[]) {
        String number = "710635810";
        String regionCode = "KE";
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        try {
            Phonenumber.PhoneNumber numberProto = phoneUtil.parse(number, regionCode);
            if (phoneUtil.isValidNumber(numberProto)){
                System.out.println("Original Number " + number);

                String formattedNatl = phoneUtil.format(numberProto, PhoneNumberUtil.PhoneNumberFormat.NATIONAL);
                System.out.println("National Format - " + formattedNatl);

                String formattedE164 = phoneUtil.format(numberProto, PhoneNumberUtil.PhoneNumberFormat.E164);
                System.out.println("E164 Format - " + formattedE164);

                String formattedIntl = phoneUtil.format(numberProto, PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL);
                System.out.println( "International Format - " + formattedIntl);
            }else{
                System.out.print(number + " is not a valid Kenyan Phone Number");
            }

        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: "
                    + e.toString());
        }
    }
}
