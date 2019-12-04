package com.example.demo.controller;

//import com.example.demo.entity.Person;

//import com.example.demo.repository.PersonRepository;
import org.apache.catalina.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.ws.rs.core.Response;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {
    @Value("${name}")
    private String name;
//    @Autowired
//    private PersonRepository personRepository;
    @RequestMapping("findCommodity")
    public Map<String, Object> findCommodity(String base64Img){
        System.out.println(base64Img);
        Map<String, Object> map = new HashMap<String, Object>();
        String message = "识别失败";
        if(StringUtils.isNotEmpty(base64Img)){
            String commodityName="雀巢_惠氏";
            String commoditySuitAge="3-5岁";
            map.put("名称",commodityName);
            map.put("适龄",commoditySuitAge);
        }
        return map;
    }
    @RequestMapping("addData")
    public Map<String, Object> addDate(String base64Img){
        System.out.println(base64Img);
        Map<String, Object> map = new HashMap<String, Object>();
        if(StringUtils.isNotEmpty(base64Img)){
            map.put("是否翻拍",false);
            map.put("行人个数",0);
            map.put("总商品数",100);
            map.put("总缺货率",0.25);
            map.put("惠氏产品占比",0.33);
            List<Map<String, String>> list=new ArrayList<>();
            Map<String, String> listMap = new HashMap<String, String>();
            listMap.put("name","惠氏-竞品-盒装");
            listMap.put("个数","17");
            listMap.put("比例","0.17");
            list.add(listMap);
            Map<String, String> listMap2 = new HashMap<String, String>();
            listMap2.put("name","惠氏-竞品-罐装");
            listMap2.put("个数","15");
            listMap2.put("比例","0.15");
            list.add(listMap2);
            Map<String, String> listMap3 = new HashMap<String, String>();
            listMap3.put("name","惠氏-竞品-碗装");
            listMap3.put("个数","14");
            listMap3.put("比例","0.14");
            list.add(listMap3);

            map.put("各种类产品个数及比例",list);

            List<List<String>> list1=new ArrayList<>();
            List<String> list2=new ArrayList<>();
            List<String> list3=new ArrayList<>();
            List<String> list4=new ArrayList<>();
            list2.add("惠氏-竞品-盒装: 1,2,3");
            list2.add("惠氏-竞品-盒装: 4,5,6");
            list2.add("惠氏-竞品-盒装: 7,8,9");
            list2.add("惠氏-竞品-盒装: 10,11,12");
            list2.add("惠氏-竞品-盒装: 13,14,15");

            list3.add("惠氏-竞品-罐装: 1,2,3");
            list3.add("惠氏-竞品-罐装: 4,5,6");
            list3.add("惠氏-竞品-罐装: 7,8,9");
            list3.add("惠氏-竞品-盒装: 10,11,12");
            list3.add("惠氏-竞品-盒装: 13,14,15");

            list4.add("惠氏-竞品-碗装: 1,2,3");
            list4.add("惠氏-竞品-碗装: 4,5,6");
            list4.add("惠氏-竞品-碗装: 7,8,9");
            list2.add("惠氏-竞品-盒装: 10,11,12");
            list2.add("惠氏-竞品-盒装: 13,14,15");
            list1.add(list2);
            list1.add(list3);
            list1.add(list4);
            map.put("排面信息",list1);
        }
        return map;
    }
    @PostMapping("/hello")
    @ResponseBody
    public String index() {
        return "Hello "+name;
    }
    @RequestMapping("getUser")
    public Map<String, Object> getUser(){
        System.out.println("微信小程序正在调用。。。");
        Map<String, Object> map = new HashMap<String, Object>();
        List<String> list = new ArrayList<String>();
        list.add("zhangsan");
        list.add("lisi");
        list.add("wanger");
        list.add("mazi");
        map.put("list",list);
        System.out.println("微信小程序调用完成。。。");
        return map;
    }
    @RequestMapping("getWord")
    public Map<String, Object> getText(String word){
        System.out.println(word);
        Map<String, Object> map = new HashMap<String, Object>();
        String message = "我能力有限，不要为难我";
        if ("后来".equals(word)) {
            message="正在热映的后来的我们是刘若英的处女作。";
        }else if("微信小程序".equals(word)){
            message= "想获取更多微信小程序相关知识，请更多的阅读微信官方文档，还有其他更多微信开发相关的内容，学无止境。";
        }else if("北邮".equals(word)){
            message="北京邮电大学（Beijing University of P" +
                    "osts and Telecommunications），简称北邮，是中华" +
                    "人民共和国教育部直属、工业和信息化部共建的全国重点" +
                    "大学，位列国家“211工程”、“985工程优势学科创新平台”" +
                    "、“世界一流学科建设高校”，是北京高科大学联盟成员高校，" +
                    "是中国政府奖学金来华留学生接收院校、国家建设高水平大学公派研" +
                    "究生项目实施高校、全国深化创新创业教育改革示范高校、国家大学生" +
                    "文化素质教育基地，入选国家“111计划”、“2011计划”和教育部首批" +
                    "“卓越工程师教育培养计划”、“新工科研究与实践项目”。";
        }
        map.put("message", message);
        return map;
    }


    @RequestMapping("getText")
    public String getText(){
        return "hello world";
    }
    /*@RequestMapping("/test")
    @ResponseBody
    public String testWApp() {
        List<Person> l=new ArrayList<Person>();
        Person p=new Person();
        p.setId(1);
        p.setName("张三");
        p.setAge(12);
        l.add(p);
        Writer out=response.g
    }*/

//    @RequestMapping("/user")
//    public Map<String, String> user(){
//        Map<String, String> map = new HashMap<String, String>();
//        Person person =personRepository.getOne(1);
//       //JSONObject jsonObject=new JSONObject();
//        //jsonObject.put("name",person);
//        map.put("name",person.getName());
//        map.put("age",person.getAge()+"");
//        map.put("id",person.getId()+"");
//        return map;
//        //return "name: "+person.getName()+"age: "+person.getAge();
//    }
//    @RequestMapping("/list")
//
//    public String getUser(@RequestBody Person person,@RequestBody String nickname){
//
//
//        /*JSONObject personJson=jsonObject.getJSONObject("person");
//        System.out.println(personJson.toString());
//        Person person=new Person();
//        person.setName(personJson.getString("name"));
//        person.setAge(personJson.getInteger("age"));
//        person.setId(personJson.getInteger("id"));
//*/
//        //return "name: "+person.getName()+"age: "+person.getAge();
//        JSONObject personJson=new JSONObject();
//        personJson.put("aa",nickname);
//        return  "name: "+person.getName()+"age: "+person.getAge()+"nickname:"+nickname;
//    }
}

//<dependency>
//  <groupId>com.baidu.aip</groupId>
//  <artifactId>java-sdk</artifactId>
//  <version>4.8.0</version>
//</dependency>
//<dependency>
//  <groupId>junit</groupId>
//  <artifactId>junit</artifactId>
//  <version>4.12</version>
//</dependency>

//    AipFace aipFace = null;
//    //1.Initialize Creating Client Objects for Java Interacting with Baidu Cloud AI
//    @Before
//    public void init(){
//        aipFace = new AipFace("16733711","gTiLQO9dPXwW8Ft7ZDvW0X4X","YZpDZ1hfwoybnbQkF5gBDdFGZIaCEQuu");
//    }

//    //Face registration
//    @Test
//    public void testFaceRegister() throws Exception {
//        //Input optional parameter call interface
//        HashMap<String, String> options = new HashMap<String, String>();
//        options.put("quality_control", "NORMAL");
//        options.put("liveness_control", "LOW");
//        String imageType = "BASE64";
//        String groupId = "ruoyi";
//        String userId = "1000";
//        //onstructing Base64 Picture String
//        String path = "C:\\Users\\ThinkPad\\Desktop\\Picture\\001.png";
//        byte[] bytes = Files.readAllBytes(Paths.get(path));
//        String image = Base64Util.encode(bytes);
//        // Face registration
//        JSONObject res = client.addUser(image, imageType, groupId, userId, options);
//        System.out.println(res.toString(2));
//    }

//    //Face detection
//    @Test
//    public void faceDetect() throws Exception {
//        String path = "C:\\Users\\Administrator\\Pictures\\Saved Pictures\\145657.png";
//        byte[] bytes = Files.readAllBytes(Paths.get(path));
//        String image = Base64Util.encode(bytes);
//        String imageType = "BASE64";
//        HashMap<String, String> subOptions = new HashMap<String, String>();
//        subOptions.put("max_face_num", "10");
//        //Face detection
//        JSONObject res = aipFace.detect(image, imageType, null);//Null means default
//        System.out.println(res.toString(2));//Adding parameter 2 to express formatting
//    }
//@Test
//public void faceSearch() throws Exception {
//    String path = "C:\\Users\\Administrator\\Pictures\\Saved Pictures\\002.png";
//    byte[] bytes = Files.readAllBytes(Paths.get(path));
//    String image = Base64Util.encode(bytes);
//    String imageType = "BASE64";
//    HashMap<String, String> options = new HashMap<String, String>();
//    options.put("user_top_num", "1");
//    //Face search
//    JSONObject res = aipFace.search(image, imageType, "ruoyi", options);
//    System.out.println(res.toString(2));
//
//}

///**
// * Login
// * @param data
// * @return
// */
//@RequestMapping(value = "/login",method = { RequestMethod.POST})
//public LoginResultVo loginRequest(@RequestParam("data") String data){
//    LoginResultVo loginResultVo = new LoginResultVo();
//    try {
//        Gson gson = new Gson();
//        LoginRequestVo loginRequestVo = gson.fromJson(data,LoginRequestVo.class);
//        String username = loginRequestVo.getUsername();
//        UsersEntity usersEntity=loginRepository.findByUsername(username);
//        String password = usersEntity.getUsername();
//        if (loginRequestVo.getPassword.equals(password)){
//            loginResultVo.setCode(200);
//            loginResultVo.setInfo("The password is correct, login successful.");
//        }else{
//            loginResultVo.setCode(400);
//            loginResultVo.setInfo("Wrong password, login failed");
//        }
//        return loginResultVo;
//    }catch (Exception e){
//        e.printStackTrace();
//    }
//    return loginResultVo;
//}