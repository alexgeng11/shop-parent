<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript" src="//api.map.baidu.com/api?v=2.0&ak=CGhEiZ7n3drAiBoS0ZW5bCLKnuxjfi2z"></script>
    <style type="text/css">
        body, html,#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;font-family:"微软雅黑";}
    </style>
</head>
<body>
<div id="allmap"></div>
</body>
<script type="text/javascript">
    // 百度地图API功能
    var map = new BMap.Map("allmap");    // 创建Map实例
    map.centerAndZoom(new BMap.Point(116.404, 39.915), 11);  // 初始化地图,设置中心点坐标和地图级别
    //添加地图类型控件
    map.addControl(new BMap.MapTypeControl({
        mapTypes:[
            BMAP_NORMAL_MAP,
            BMAP_HYBRID_MAP
        ]}));
    map.setCurrentCity("北京");          // 设置地图显示的城市 此项是必须设置的
    map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
    var textLabel
    var point =new BMap.Point(116.404, 39.915);
    var text='<p style="margin-top: 20px; pointer-events: none">海淀区</p>' + '<p style="pointer-events: none">5套</p>';
    textLabel=new BMap.Label(text,{
        position:point,
        offset:new BMap.Size(-39,-39)
    });
    textLabel.setStyle({
        height: '78px',
        width: '78px',
        color: '#fff',
        backgroundColor: '#0054a5',
        border: '0px solid rgb(255, 0, 0)',
        borderRadius: "50%",
        fontWeight: 'bold',
        display: 'inline',
        lineHeight: 'normal',
        textAlign: 'center',
        opacity: '0.8',
        zIndex: 2,
        overflow: 'hidden'
    })
    map.addOverlay(textLabel); // 将标签画在地图上
</script>
</html>