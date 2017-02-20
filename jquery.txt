jQuery(document).ready(function() {
	$("a").click(function() //取得是标签名所以可以是多个
		{
		alert("Hello world!");
		});
		$("#orderedlist").addClass("red");//#指ID,addClass其实就是加一个属性class=red。.red定义在screen.css文件下。
		$("#orderedlist > li").addClass("blue");
		$("#orderedlist li:last").hover(function() {//:last选择其中的最后一个，hover应该有两个参数分别是对某个函数的引用，所以在这里实现了两个方法，一个鼠标进入时的动作，另一个是鼠标离开时的动作。
		$(this).addClass("green");
	}, function() {
		$(this).removeClass("green");
	});

$("#orderedlist").find("li").each(function(i) {//each(function(i))可以用来遍历一个数组，而html(a)函数相当于innerHTML=a,当没有a时取出所有的html代码。
		$(this).html( $(this).html() + " BAM! " + i );
	});

$("#reset").click(function() {
		alert($("#form1").size());//$("#form")中取得的都是数组，而.reset()方法只能用在单个对象上，或者象下面一样用.each()函数迭代它
		$("#form1")[0].reset();
	});

	// use this to reset several forms at once
	$("#reset").click(function() {
		$("form").each(function() {
			this.reset();
		});
	});

$("li").not("[ul]").filter("[ul]").css("border", "1px solid black");//not去除所有成立的项，filter过滤所有成立的项，[ul]Xpath的写法，代表子节点或者属性。

$("a[@name]").background("#eef");//[@name]代表属性为name的项#eee颜色的表示方式每一位代表两个相同的十六进制数

$("a[@href*=#]").click(function() {
		$("a[@href*=#]").background("#3af");//*=代表模糊匹配
	});

	$('#faq').find('dd').hide().end().find('dt').click(function() {//end()结束find()的返回值，使得返回值重新变回$("#faq"),dd和dt分别为两种列表的形式
         var answer = $(this).next();
         if (answer.is(':visible')) {//next()取得排在当前控件下面的控件，is()判断情况返回true或false
             answer.slideUp();//收起当前元素
			 alert("收起");
         } else {
             answer.slideDown();//展现当前元素
         }
     });

$("a").hover(function() {
		$(this).parents("p").addClass("highlight");//parents(arg)取得当前控件的父控件,如参数中不加具体的控件名，取得和释放的过程会比较虚。
	}, function() {
		$(this).parents("p").removeClass("highlight");
	});
/*
$(function() {
	var addClickHandlers = function() {
		$("a.clickMeToLoadContent").click(function() {
			$("#target").load(this.href, addClickHandlers);
		});
	};
	addClickHandlers();
});

$("a").toggle(function() {
		$(".stuff").hide('slow');
	}, function() {
		$(".stuff").show('fast');
	});
*/

$("a").toggle(function() {//单选按钮模式支持点击的两种不同函数
		$(".stuff").animate({//动画效果支持这次变化
			height: 'hide',//高度隐藏
			opacity: 'hide'//透明度隐藏
		}, 1000);//速度slow代表600毫秒
	}, function() {
		$(".stuff").animate({
			height: 'show',
			opacity: 'show'
		}, 'slow');
	});


});