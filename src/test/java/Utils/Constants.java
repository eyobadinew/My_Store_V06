package Utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {
    // naming convention for constants is All CAPITAL LETTER with underscore


    public static final String HOME_PAGE_TITLE = "e-commerce; Automation Practice Website";
    public static final String LOGIN_PAGE_TITLE = "My account; e-commerce";
    public static final String MAC_PAGE_TITLE = "Mac; e-commerce";
    public static final String IPHONE_PAGE_TITLE = "iPhone; e-commerce";
    public static final String WATCH_PAGE_TITLE = "Watch; e-commerce";
    public static final String ACCESSORIES_PAGE_TITLE = "Accessories; e-commerce";
    public static final String PRIVACY_POLICY_PAGE_TITLE = "Privacy Policy; e-commerce";

    public static final String ACCOUNTS_PAGE_HEADER = "Your Store";
    public static final int ACCOUNT_SECTIONS = 4;
    public static List<String> getAccountSectionsList() {
        List<String> accountList = new ArrayList<>();
        accountList.add("My Account");
        accountList.add("My Orders");
        accountList.add("My Affiliate Account");
        accountList.add("Newsletter");
        return accountList;
    }
}
