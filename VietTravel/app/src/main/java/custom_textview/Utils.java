package custom_textview;

import android.content.Context;
import android.graphics.Typeface;

public class Utils {
    private static Typeface NotoSerifBoldTypeFace;
    private static Typeface NotoSerifRegularTypeFace;
    private static Typeface RobotoBlackTypeFace;
    private static Typeface RobotoRegularTypeFace;
    private static Typeface RobotoMdediumTypeFace;

    public static Typeface getNotoSerifBoldTypeFace(Context context) {
        if(NotoSerifBoldTypeFace == null){
            NotoSerifBoldTypeFace = Typeface.createFromAsset(context.getAssets(), "fonts/NotoSerif-Bold.ttf");
        }
        return NotoSerifBoldTypeFace;
    }

    public static Typeface getNotoSerifRegularTypeFace(Context context) {
        if(NotoSerifRegularTypeFace == null){
            NotoSerifRegularTypeFace = Typeface.createFromAsset(context.getAssets(), "fonts/NotoSerif-Regular.ttf");
        }
        return NotoSerifRegularTypeFace;
    }

    public static Typeface getRobotoBlackTypeFace(Context context) {
        if(RobotoBlackTypeFace == null){
            RobotoBlackTypeFace = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Black.ttf-Bold.ttf");
        }
        return RobotoBlackTypeFace;
    }

    public static Typeface getRobotoRegularTypeFace(Context context) {
        if(RobotoRegularTypeFace == null){
            RobotoRegularTypeFace = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Regular.ttf");
        }
        return RobotoRegularTypeFace;
    }

    public static Typeface getRobotoMdediumTypeFace(Context context) {
        if(RobotoMdediumTypeFace == null){
            RobotoMdediumTypeFace = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Medium.ttf.ttf");
        }
        return RobotoMdediumTypeFace;
    }
}
