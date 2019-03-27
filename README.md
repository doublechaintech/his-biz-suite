
# 界面通过特别技术自动生成

<img src='/doc/his-sys-interface.png'  width="400"/>

* 自动生成表定义
* 自动生成界面
* 自动生成后台代码
* 自动翻译


# 演示地址 

https://demo.doublechaintech.com/admin/his/#/home

* 医院登录: 13900000001/DoubleChain!y1
* 医生登录：13900000002/DoubleChain!y1

# 源文件（用文本文件写60多行的文件就可以生成完整应用）

通过以下文件生成
* 多角色前台React/Antd管理界面
* 后台Java
* 数据库规格
* 演示数据

```
<?xml version='1.0' ?>
<root org="doublechaintech" 
	chinese_name="医生排班系统" 
	english_name="Doctor Scheduling System">

	
    <hospital   
        name="上和医院|[1,200]"  
        address="毕升路22号" 
        telephone="028-9123123" />
	
    <expense_type  
        name="诊疗费|治疗费|检查费"  
        helper_chars="zlf|zlf|jcf"  
        status="正常|停用" 
        hospital="$(hospital)"
        description="text()"   
        update_time="updateTime()"        
        _features="setting"
    />
    <period  
        name="上午|下午|夜班"   
        hospital="$(hospital)"         
        _features="status"   />
    <expense_item
        name="专家诊疗费|血常规|煎药费"       
        price="$99999999999.00"       
        expense_type="$(expense_type)"
        hospital="$(hospital)"        
        update_time="updateTime()"       
         _features="setting"
    />

    <doctor
        name="魏松全"
        shot_image="snap.shot-400-300-red.jpg"
        hospital="$(hospital)"
        update_time="updateTime()"
        
    />

    <department
        name="放射科" 
        hospital="$(hospital)" 
        update_time="updateTime()" 
        _features="setting"
 
    />
    
    <doctor_assignment
        name="魏松全在内分泌科室上" 
        doctor="$(doctor)"
        department="$(department)" 
        update_time="updateTime()"  
        _features="setting"
 
    />
    <doctor_schedule
        name="2019年3月11日魏松全在内分泌科坐班收诊疗费,每个10"
        doctor="$(doctor)"  
        schedule_date="2019-3-11" 
        period="$(period)"
        department="$(department)" 
        available="20"  price="$123.99"
        expense_type="$(expense_type)" 
        create_time="createTime()"  
        update_time="updateTime()" 
        hospital="$(hospital)"
    />
    

</root>
 
 
 
```

# 开发工具近期将以SaaS服务方式公开服务，敬请期待
下载手册 
<br/>
<img src='/doc/manual.jpg'  width="400"/>
