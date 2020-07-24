package com.estrus.script;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileReader;

public class Demo1 {
    public static void main(String[] args) throws Exception {

        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        engine.eval("print('hello world')");
        engine.eval(new FileReader("src/main/resources/script/script1.js"));
        //Java中调用js文件中的function，传入调用参数，并获取返回值
        engine.eval("a = f(1,2)");
        Object a = engine.get("a");
        System.out.println(a);
    }
}
