package biz.osvit.android.osvitblogspot.commons.utils;

public final class StringUtils {

    public static boolean isTypeOfEmail(CharSequence target) {
        return target != null && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}