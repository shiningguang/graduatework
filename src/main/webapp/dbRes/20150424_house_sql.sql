//添加楼盘信息或者是详细住址，比如A座3301室。这就是detail字段所表示的意思
ALTER TABLE 
house 
ADD COLUMN detail VARCHAR(20) NOT NULL;

//添加房屋主人的外键，可以直接检索的房主
ALTER TABLE 
house 
ADD COLUMN h_a_id INT(50);