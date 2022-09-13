CREATE TABLE productCategory(
    id SERIAL PRIMARY KEY,
    keywords VARCHAR(10) NOT NULL,
    level SMALLINT NOT NULL，
    parent_Id SMALLINT NOT NULL
)

INSERT INTO productCategory(keywords,level，parent_Id)VALUES("服装",0，0);
INSERT INTO productCategory(keywords,level，parent_Id)VALUES("手机数码",0，0);
INSERT INTO productCategory(keywords,level，parent_Id)VALUES("家用电器",0，0);
INSERT INTO productCategory(keywords,level，parent_Id)VALUES("家具家装",0，0);
INSERT INTO productCategory(keywords,level，parent_Id)VALUES("汽车用品",0，0);
INSERT INTO productCategory(keywords,level，parent_Id)VALUES("外套",1，1);
INSERT INTO productCategory(keywords,level，parent_Id)VALUES("T恤",1，1);
INSERT INTO productCategory(keywords,level，parent_Id)VALUES("休闲裤",1，1);
INSERT INTO productCategory(keywords,level，parent_Id)VALUES("牛仔裤",1，1);
INSERT INTO productCategory(keywords,level，parent_Id)VALUES("衬衫",1，1);
INSERT INTO productCategory(keywords,level，parent_Id)VALUES("男鞋",1，1);
INSERT INTO productCategory(keywords,level，parent_Id)VALUES("手机通讯",1，2);
INSERT INTO productCategory(keywords,level，parent_Id)VALUES("手机配件",1，2);
INSERT INTO productCategory(keywords,level，parent_Id)VALUES("摄影摄像",1，2);
INSERT INTO productCategory(keywords,level，parent_Id)VALUES("影音娱乐",1，2);
INSERT INTO productCategory(keywords,level，parent_Id)VALUES("数码配件",1，2);
INSERT INTO productCategory(keywords,level，parent_Id)VALUES("智能设备",1，2);
INSERT INTO productCategory(keywords,level，parent_Id)VALUES("电视",1，3);
INSERT INTO productCategory(keywords,level，parent_Id)VALUES("空调",1，3);
INSERT INTO productCategory(keywords,level，parent_Id)VALUES("洗衣机",1，3);
INSERT INTO productCategory(keywords,level，parent_Id)VALUES("冰箱",1，3);
INSERT INTO productCategory(keywords,level，parent_Id)VALUES("厨卫大电",1，3);
INSERT INTO productCategory(keywords,level，parent_Id)VALUES("厨房小电",1，3);
INSERT INTO productCategory(keywords,level，parent_Id)VALUES("生活电器",1，3);
INSERT INTO productCategory(keywords,level，parent_Id)VALUES("个护健康",1，3);
INSERT INTO productCategory(keywords,level，parent_Id)VALUES("厨房卫浴",1，4);
INSERT INTO productCategory(keywords,level，parent_Id)VALUES("灯饰照明",1，4);
INSERT INTO productCategory(keywords,level，parent_Id)VALUES("五金工具",1，4);
INSERT INTO productCategory(keywords,level，parent_Id)VALUES("卧室家具",1，4);
INSERT INTO productCategory(keywords,level，parent_Id)VALUES("客厅家具",1，4);
INSERT INTO productCategory(keywords,level，parent_Id)VALUES("全新整车",1，5)；
INSERT INTO productCategory(keywords,level，parent_Id)VALUES("车载电器",1，5);
INSERT INTO productCategory(keywords,level，parent_Id)VALUES("维修保养",1，5);
INSERT INTO productCategory(keywords,level，parent_Id)VALUES("汽车装饰",1，5);