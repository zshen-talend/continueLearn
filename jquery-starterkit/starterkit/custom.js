jQuery(document).ready(function() {
	$("a").click(function() //ȡ���Ǳ�ǩ�����Կ����Ƕ��
		{
		alert("Hello world!");
		});
		$("#orderedlist").addClass("red");//#ָID,addClass��ʵ���Ǽ�һ������class=red��.red������screen.css�ļ��¡�
		$("#orderedlist > li").addClass("blue");
		$("#orderedlist li:last").hover(function() {//:lastѡ�����е����һ����hoverӦ�������������ֱ��Ƕ�ĳ�����������ã�����������ʵ��������������һ��������ʱ�Ķ�������һ��������뿪ʱ�Ķ�����
		$(this).addClass("green");
	}, function() {
		$(this).removeClass("green");
	});

$("#orderedlist").find("li").each(function(i) {//each(function(i))������������һ�����飬��html(a)�����൱��innerHTML=a,��û��aʱȡ�����е�html���롣
		$(this).html( $(this).html() + " BAM! " + i );
	});

$("#reset").click(function() {
		alert($("#form1").size());//$("#form")��ȡ�õĶ������飬��.reset()����ֻ�����ڵ��������ϣ�����������һ����.each()����������
		$("#form1")[0].reset();
	});

	// use this to reset several forms at once
	$("#reset").click(function() {
		$("form").each(function() {
			this.reset();
		});
	});

$("li").not("[ul]").filter("[ul]").css("border", "1px solid black");//notȥ�����г������filter�������г������[ul]Xpath��д���������ӽڵ�������ԡ�

$("a[@name]").background("#eef");//[@name]��������Ϊname����#eee��ɫ�ı�ʾ��ʽÿһλ����������ͬ��ʮ��������

$("a[@href*=#]").click(function() {
		$("a[@href*=#]").background("#3af");//*=����ģ��ƥ��
	});

	$('#faq').find('dd').hide().end().find('dt').click(function() {//end()����find()�ķ���ֵ��ʹ�÷���ֵ���±��$("#faq"),dd��dt�ֱ�Ϊ�����б����ʽ
         var answer = $(this).next();
         if (answer.is(':visible')) {//next()ȡ�����ڵ�ǰ�ؼ�����Ŀؼ���is()�ж��������true��false
             answer.slideUp();//����ǰԪ��
			 alert("����");
         } else {
             answer.slideDown();//չ�ֵ�ǰԪ��
         }
     });

$("a").hover(function() {
		$(this).parents("p").addClass("highlight");//parents(arg)ȡ�õ�ǰ�ؼ��ĸ��ؼ�,������в��Ӿ���Ŀؼ�����ȡ�ú��ͷŵĹ��̻�Ƚ��顣
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

$("a").toggle(function() {//��ѡ��ťģʽ֧�ֵ�������ֲ�ͬ����
		$(".stuff").animate({//����Ч��֧����α仯
			height: 'hide',//�߶�����
			opacity: 'hide'//͸��������
		}, 1000);//�ٶ�slow����600����
	}, function() {
		$(".stuff").animate({
			height: 'show',
			opacity: 'show'
		}, 'slow');
	});


});