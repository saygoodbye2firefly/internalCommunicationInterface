package mzy.com.easytransmit;

import java.util.ArrayList;
import java.util.List;

/***
 * 请在自己的代码添加自定义action集
 * action为识别传递对象的码尽量唯一
 */
public class InsideUpdate {

    public static interface UpdateNotify {
        /**
         * @param action 更新指令
         * @param value  回传值 可变参数可以不传值
         */
        public void updateUi(int action, Object... value);
    }

    private InsideUpdate() {
    }

    private static List<UpdateNotify> mCalBaks = new ArrayList<>();

    public static void addClientNotify(UpdateNotify updateNotify) {
        mCalBaks.add(updateNotify);
    }

    public static void removeClientNotify(UpdateNotify updateNotify) {
        mCalBaks.remove(updateNotify);
    }

    /**
     * @param action 指令
     * @param value  回传值
     */
    public static void sendNotify(int action, Object... value) {
        if (mCalBaks.size() > 0) {
            for (UpdateNotify updateNotify : mCalBaks) {
                updateNotify.updateUi(action, value);
            }
        }
    }
}
