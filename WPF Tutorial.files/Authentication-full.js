var txtUsername;var txtPassword;var textLoggedIn;var textNotLoggedIn;var buttonLogin;var buttonLogout;function authentication_pageLoad()
{Sys.Services.AuthenticationService.set_path('/Authentication_JSON_AppService.axd');txtUsername=$get("txtLoginUserName");txtPassword=$get("txtLoginPassword");textLoggedIn=$get("loggedin");textNotLoggedIn=$get("notloggedin");buttonLogin=$get("ButtonLogin");buttonLogout=$get("ButtonLogout");$U.focus(txtUsername);window.onscroll=function(){positionModal();}}
function SetDefaultLoginCompletedCallBack()
{Sys.Services.AuthenticationService.set_defaultLoginCompletedCallback(OnLoginCompleted);var callBack=Sys.Services.AuthenticationService.get_defaultLoginCompletedCallback();}
function SetDefaultLogoutCompletedCallBack()
{Sys.Services.AuthenticationService.set_defaultLogoutCompletedCallback(OnLogoutCompleted);var callBack=Sys.Services.AuthenticationService.get_defaultLogoutCompletedCallback();}
function SetDefaultFailedCallBack()
{Sys.Services.AuthenticationService.set_defaultFailedCallback(OnFailed);var callBack=Sys.Services.AuthenticationService.get_defaultFailedCallback();}
function OnClickLogin()
{$U.noDisplayChidren('divLogin','span','validator');$U.noDisplay('loginMessage');var username=$get("txtLoginUserName").value.trim();if(username.length==0)
{showMessage('valLoginUserName','User name is required..',true);$U.focus(txtUsername);return;}
var txtPassword=$get('txtLoginPassword');var password=txtPassword.value;if(password.length==0)
{showMessage('valLoginPassword','Password cannot be blank.',true);$U.focus(txtPassword);return;}
var rememberMe=$get('chkLoginRememberMe').checked;SetDefaultLoginCompletedCallBack();SetDefaultLogoutCompletedCallBack();SetDefaultFailedCallBack();Sys.Services.AuthenticationService.login(username,password,rememberMe,null,null,null,null,"User Context");}
function OnClickLogout()
{Sys.Services.AuthenticationService.logout(null,null,null,null);}
function OnFailed(error,userContext,methodName)
{}
function OnLoginCompleted(validCredentials,userContext,methodName)
{txtPassword.value="";if(validCredentials==true)
{MembershipService.CreateCSCookie(txtUsername.value.trim(),createCSCookie_Callback);}
else
{showMessage('loginMessage','Invalid login credentials.',true);$U.focus('txtLoginUserName');}}
function createCSCookie_Callback(result,eventArgs)
{window.location.reload();}
function OnLogoutCompleted(result)
{}
function showMessage(e,msg,err)
{var e=$U.fix(e);if(err)
{e.style.color='#ff0000';}
else
{e.style.color='';}
$U.setText(e,msg);$U.display(e);}
function sendPassword()
{$U.noDisplayChidren('divLogin','span','validator');$U.noDisplay('passwordMessage');var txtEmail=$get('txtForgotEmail');var email=txtEmail.value.trim();if(email.length==0)
{showMessage('valForgotEmail','Email cannot be blank.',true);$U.focus(txtEmail);return;}
if(!isValidEmail(email))
{showMessage('valForgotEmail','Invalid email address.',true);$U.focus(txtEmail);return;}
showMessage('passwordMessage','Sending password...',false);$get('btnPassword').disabled=true;MembershipService.ForgotPassword(email,sendPassword_Callback);}
function sendPassword_Callback(result,eventArgs)
{showMessage('passwordMessage',result,false);$get('btnPassword').disabled=false;}
function isValidEmail(email)
{var regExp=/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;return regExp.test(email);}
function showLogin()
{$get("txtLoginUserName").value='';$get("txtLoginPassword").value='';$U.setText('valLoginUserName','');$U.setText('valLoginPassword','');$U.setText('loginMessage','');$U.setText('valForgotEmail','');$U.setText('passwordMessage','');var divModal=$get('divMembershipBox');var divDim=$get('divDimBackground');$U.display(divModal);$U.display(divDim);var modalBounds=Sys.UI.DomElement.getBounds(divModal);var viewPortWidth=$U.getViewPortWidth();var viewPortHeight=$U.getViewPortHeight();var contentHeight=$U.getContentHeight();var x=Math.round((viewPortWidth-modalBounds.width)/2);var y=Math.round((viewPortHeight-modalBounds.height)/2);divDim.style.width=viewPortWidth+'px';divDim.style.height=Math.max(viewPortHeight,contentHeight)+'px';$U.setLocation(divModal,x,y);$U.setLocation(divDim,0,0);positionModal();}
function positionModal()
{var divModal=$get("divMembershipBox");if(divModal!=null)
{if(divModal.style.display=="")
{var newRect=$U.getWindowInformation();var modalXPos=newRect.ScrollY+(newRect.Height/2)-75;$get("divMembershipBox").style.top=modalXPos+"px";}}}
function hideLogin()
{$U.noDisplay('divDimBackground');$U.noDisplay('divMembershipBox');}
if(typeof(Sys)!=="undefined")
{Sys.Application.add_init(authentication_pageLoad);Sys.Application.notifyScriptLoaded();}
var $U={display:function(e){$U.fix(e).style.display=''},displayBlock:function(e){$U.fix(e).style.display='block'},noDisplay:function(e){$U.fix(e).style.display='none'},show:function(e){$U.fix(e).style.visibility='visible'},hide:function(e){$U.fix(e).style.visibility='hidden'},setText:function(e,t){e=$U.fix(e);if(document.all){e.innerText=t}else{e.textContent=t}},focus:function(e){e=$U.fix(e);try{e.select()}catch(e){}try{e.focus()}catch(e){}},setLocation:function(e,x,y){e=$U.fix(e);Sys.UI.DomElement.setLocation(e,x,y)},resetInputs:function(){if(arguments.length>0){var container;var controls;var control;for(var i=0;i<arguments.length;i++){container=$U.fix(arguments[i]);controls=container.getElementsByTagName('input');if(controls.length>0){for(var j=0;j<controls.length;j++){control=controls[j];if((control.type=='text')||(control.type=='file')||(control.type=='password')){control.value=''}else if((control.type=='checkbox')||(control.type=='radio')){control.checked=false}}}}}},displayChidren:function(e,t,c){$U.displayOrNoDisplayChidren(true,e,t,c)},noDisplayChidren:function(e,t,c){$U.displayOrNoDisplayChidren(false,e,t,c)},displayOrNoDisplayChidren:function(display,e,t,c){e=$U.fix(e);var elms=e.getElementsByTagName(t);if(elms.length>0){var e;for(var i=0;i<elms.length;i++){e=elms[i];if(c){if(Sys.UI.DomElement.containsCssClass(e,c)){if(display){$U.display(e)}else{$U.noDisplay(e)}}}else{if(display){$U.display(e)}else{$U.noDisplay(e)}}}}},fix:function(e){if(typeof e!='object'){e=$get(e)}return e},getViewPortWidth:function(){var width=0;if((document.documentElement)&&(document.documentElement.clientWidth)){width=document.documentElement.clientWidth}else if((document.body)&&(document.body.clientWidth)){width=document.body.clientWidth}else if(window.innerWidth){width=window.innerWidth}return width},getViewPortHeight:function(){var height=0;if(window.innerHeight){height=window.innerHeight}else if((document.documentElement)&&(document.documentElement.clientHeight)){height=document.documentElement.clientHeight}else if((document.body)&&(document.body.clientHeight)){height=document.body.clientHeight}return height},getContentHeight:function(){if((document.body)&&(document.body.offsetHeight)){return document.body.offsetHeight}return 0},parseQueryString:function(url){url=new String(url);var queryStringValues=new Object();var querystring=url.substring((url.indexOf('?')+1),url.length);var querystringSplit=querystring.split('&');for(var i=0;i<querystringSplit.length;i++){var pair=querystringSplit[i].split('=');var name=pair[0];var value=pair[1];queryStringValues[name]=value}return queryStringValues},getWindowInformation:function(){var myWidth=0,myHeight=0,contentWidth=0,contentHeight=0;if(typeof(window.innerWidth)=='number'){myWidth=window.innerWidth;myHeight=window.innerHeight}else if(document.documentElement&&(document.documentElement.clientWidth||document.documentElement.clientHeight)){myWidth=document.documentElement.clientWidth;myHeight=document.documentElement.clientHeight}else if(document.body&&(document.body.clientWidth||document.body.clientHeight)){myWidth=document.body.clientWidth;myHeight=document.body.clientHeight}var scrOfX=0,scrOfY=0;if(typeof(window.pageYOffset)=='number'){scrOfY=window.pageYOffset;scrOfX=window.pageXOffset}else if(document.body&&(document.body.scrollLeft||document.body.scrollTop)){scrOfY=document.body.scrollTop;scrOfX=document.body.scrollLeft}else if(document.documentElement&&(document.documentElement.scrollLeft||document.documentElement.scrollTop)){scrOfY=document.documentElement.scrollTop;scrOfX=document.documentElement.scrollLeft}if(document.documentElement&&(document.documentElement.scrollHeight||document.documentElement.offsetHeight)){if(document.documentElement.scrollHeight>document.documentElement.offsetHeight){contentWidth=document.documentElement.scrollWidth;contentHeight=document.documentElement.scrollHeight}else{contentWidth=document.documentElement.offsetWidth;contentHeight=document.documentElement.offsetHeight}}else if(document.body&&(document.body.scrollHeight||document.body.offsetHeight)){if(document.body.scrollHeight>document.body.offsetHeight){contentWidth=document.body.scrollWidth;contentHeight=document.body.scrollHeight}else{contentWidth=document.body.offsetWidth;contentHeight=document.body.offsetHeight}}else{contentWidth=width;contentHeight=height}var rect=new Object();rect.ScrollX=scrOfX;rect.ScrollY=scrOfY;rect.Width=myWidth;rect.Height=myHeight;rect.ContentWidth=contentWidth;rect.ContentHeight=contentHeight;return rect}}
var ModalProgress={DialogCssClass:'progress',DimCssClass:'dimBackground',ProgressImage:'/dnsImages/indicator.gif',ProgressText:'Loading, please wait...',_divModal:null,_divDim:null,show:function()
{var divModal=ModalProgress._divModal;var divDim=ModalProgress._divDim;if(divModal==null)
{divModal=document.createElement('div');divModal.className=ModalProgress.DialogCssClass;divModal.innerHTML='<div style=\"text-align:center;vertical-align:middle;padding-top:20px\">'+'<img alt=\"\" style=\"padding-right:4px\" src=\"'+ModalProgress.ProgressImage+'\" />'+
ModalProgress.ProgressText+'<div>';document.body.appendChild(divModal);ModalProgress._divModal=divModal;}
if(divDim==null)
{divDim=document.createElement('div');divDim.className=ModalProgress.DimCssClass;document.body.appendChild(divDim);ModalProgress._divDim=divDim;}
divModal.style.display='';divDim.style.display='';var modalBounds=Sys.UI.DomElement.getBounds(divModal);var viewPortWidth=ModalProgress._getViewPortWidth();var viewPortHeight=ModalProgress._getViewPortHeight();var contentHeight=ModalProgress._getContentHeight();var x=Math.round((viewPortWidth-modalBounds.width)/2);var y=Math.round((viewPortHeight-modalBounds.height)/2);divDim.style.width=viewPortWidth+'px';divDim.style.height=Math.max(viewPortHeight,contentHeight)+'px';Sys.UI.DomElement.setLocation(divModal,x,y);Sys.UI.DomElement.setLocation(divDim,0,0);},hide:function()
{ModalProgress._divModal.style.display='none';ModalProgress._divDim.style.display='none';},_getViewPortWidth:function()
{var width=0;if((document.documentElement)&&(document.documentElement.clientWidth))
{width=document.documentElement.clientWidth;}
else if((document.body)&&(document.body.clientWidth))
{width=document.body.clientWidth;}
else if(window.innerWidth)
{width=window.innerWidth;}
return width;},_getViewPortHeight:function()
{var height=0;if(window.innerHeight)
{height=window.innerHeight;}
else if((document.documentElement)&&(document.documentElement.clientHeight))
{height=document.documentElement.clientHeight;}
else if((document.body)&&(document.body.clientHeight))
{height=document.body.clientHeight;}
return height;},_getContentHeight:function()
{if((document.body)&&(document.body.offsetHeight))
{return document.body.offsetHeight;}
return 0;}}
Sys.Net.WebRequestManager.add_invokingRequest(function(){ModalProgress.show();});Sys.Net.WebRequestManager.add_completedRequest(function(){ModalProgress.hide();});