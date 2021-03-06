package com.github.thread.t1.oom;

/**
 * @author JiHongYuan
 * @date 2021/4/13 9:43
 */

import java.util.HashSet;
import java.util.Set;

/**
 * VM Args：-XX:PermSize=6M -XX:MaxPermSize=6M
 * @author zzm
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
// 使用Set保持着常量池引用，避免Full GC回收常量池行为
        Set<String> set = new HashSet<String>();
// 在short范围内足以让6MB的PermSize产生OOM了
        short i = 0;
        while (true) {
            set.add(String.valueOf(i++).intern());
        }
    }
}
