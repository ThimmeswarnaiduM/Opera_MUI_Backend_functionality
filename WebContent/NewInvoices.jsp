<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page import="java.io.FileWriter"%>
<%@page import="java.io.BufferedWriter"%>
<%@page import="config.GetVouchersData"%>
<%@page import="config.GiftCardData"%>
<%@page import="data.ProcessInvoicesData"%>
<%@page import="java.util.Locale"%>
<%@page import="data.StoreInvoiceDataMap"%>
<%@page import="config.GetMemberData"%>
<%@page import="config.GetProfileData"%>
<%@page import="org.w3c.dom.NodeList"%>
<%@page import="org.w3c.dom.Node"%>
<%@page import="org.w3c.dom.Element"%>
<%@page import="org.w3c.dom.Document"%>
<%@page import="config.SoapExecutor"%>
<%@page import="config.Configuration"%>
<%@page import="config.GetReservationData"%>
<%@page import="data.StoreInvoiceDetails"%>
<%@page import="data.HashMapData"%>
<%@page import="data.NewInvoicesData"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@page import="config.CurrencyConverter"%>
<%@ page import="org.json.JSONArray, org.json.JSONObject, org.json.JSONException" %>

    

    

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Reservation Details</title>





<meta name="viewport" content="width=device-width,initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge;chrome=1" />
<title></title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/custom.css" rel="stylesheet">
<link href="css/toaster.css" rel="stylesheet">
<link href="css/font-awesome.css" rel="stylesheet">
<link href="css/angular-datepicker.css" rel="stylesheet" type="text/css">



<link rel="stylesheet" href="importedLib/jquery-ui-1.11.4.css">

<link rel="stylesheet" href="importedLib/bootstrap-3.3.7.min.css">
<script src="importedLib/jquery-3.3.1.min.js"></script>
<script src="importedLib/bootstrap-3.3.7.min.js"></script>
<script src="importedLib/jquery-ui-1.11.4.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/isteven-multi-select.css">

<script src="importedLib/angular-1.6.9.min.js"></script>


<link rel="stylesheet" type="text/css" href="importedLib/jquery-confirm-3.3.2.min.css">
<script type="text/javascript" src="importedLib/jquery-confirm-3.3.2.min.js"></script>

<link href="importedLib/GoogleAPIFontCourgette.css" rel='stylesheet'>
<style>
@media (max-width: 600px) {
   html, body{
     height:100%
   }
  .navigation_bar{
     display:flex;
     height:80px;
     font-size: 15px;
  }
  .title{
     pointer-events: none;
     opacity: 0;
     cursor: not-allowed;
     width:1px;
  }
  .userpopupbtn{
     margin-top:-5px;
     
  }
  .MUITitle{
     font-size: 24px !important;
     margin-left: 20px;
     margin-top: 4px;
  }
  .closeBTN{
     margin-top: 10px !important;
  }
  .topnav{
      flex-direction: column;
      padding-bottom:10px;
  }
  .menucustom{
      width: 100% !important;
      padding-left:0px !important;
      text-align: center;
  }
  .parentmenucustom{
      width:100% !important
  }
  .MobileAvailVou{
    	
  }
  .MobileAvailOff{
  }
  .availVouchers{
      width: 100% !important;
      justify-content: center !important;
  }
  .colomnDataForMR{
      display:flex;
      flex-direction:column;
  }
  .jumbotron{
      height: 200px;
      overflow-y: auto;
  }
  .tableStyle{
      font-size: 3.5vw !important;
      display: flex;
      justify-content: flex-start;
      align-items: flex-start;
  }
  .childTableMR{
      width: 100% !important;
      display: flex;
      justify-content: center;
      align-items: flex-start;
  }
  .folios{
  display:flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  gap:15px;
  }
  .splitLeft{
  width:100% !important;
  }
  .splitLeft .container-fluid{
  margin-left:0px !important;
  padding : 0px 10px !important;
  }
  .splitLeft .container-fluid .jumbotron{
  height: 110px !important;
  }
  .splitRight{
  width:100% !important;
  }
  .splitRight .container-fluid{
  margin-left:0px !important;
  padding : 0px 10px !important;
  display: flex;
  justify-content: center;
  overflow: auto;
  }
  .splitRight .container-fluid .jumbotron{
  	height:100px !important;
  	border-radius:0px !important;
  	
  }
  .topnavBar{
     padding-left:45px;
  }
  .text-center{
  height:20px !important;
  width:70px !important;
  }
  .side-text{
  font-size: 12px !important;
  }
  .TIC-inside{
  padding-left:8px;
  padding-right: 8px;
  display:flex;
  flex-direction : row;
  justify-content: space-between;
  }
  .pull-right{
  padding-top: 5px;
  height:30px;
  }
  .place-holder{
  padding-top: 0.3em;
  }
  #divPayPoint{
  border-radius: 2px !important;
  }
  .payUsingTIC{
  font-size: 16px;
  }
  .payUsingTIC .table-responsive{
  padding-bottom: 0px !important;
  }
  .neu-coins{
  width:100% !important;
  }
  .tablefont{
  margin: 5px;
  }
  .tablefontinner{
  width:60px !important;
  font-size: 8px !important;
  }
  #expiry_voucher{
  font-size: 7px !important;
  }
  .tablefont_vouchers{
  width:100% !important;
  }
  #modalVoucherDisplay{
  width:100% !important;
  overflow:auto;
  }
  .ng-binding{
  font-size:8px !important;
  }
  .tablefontcontent{
  width: 30% !important;
  font-size:10px !important;
  padding:4px !important;
  }
  #btnAvailVoucher{
  width:55px;
  height:20px;
  padding:0px;
  font-size:8px;
  }
  #btnavailVoucher{
  padding-left:2px;
  }
  .voucher-options{
  padding-left:13px;
  font-size:13px;
  }
  .clMemberType{
  padding:1px;
  font-size:10px;
  width:50px;
  height:15px;
  }
  #loadingUIHoverVoucher{
  width:50% !important ;
  height:50% !important;
  }
  #loadingUI{
  width:200px !important;
  margin-left:10px;
  }
  #GravtyGCloadingUIHover{
  width:50% !important ;
  height:50% !important;
  }
  #lblUIHoverVoucher{
  font-size:12px !important;
  }
  #pleasewait{
  font-size:12px !important;
  }
  .loader{
  width:50px !important;
  height:50px !important;
  }
  #modal-content1{
  width:100% !important;
  }
  #modal-dialog1{
  width:100% !important
  }
  .otp_button{
  padding:0px;
  width:60px;
  height:30px;
  }
  .card_swipe_button{
  width: 95px;
  height: 30px;
  padding: 0px;
  }
  .pin_button{
  margin-top: 4px;
  width: 60px;
  height: 30px;
  padding: 0px;
  }
  .close_button{
  width:43px;
  height:30px;
  padding:0px !important;
  }
  .loadingUI{
  width:200px;
  height:200px;
  }
  #offerId{
  width: 18% !important;
  }
  #offEndDate{
  width:18% !important;
  
  }
  #RedemLeft{
  width:20% !important;
  }
  #avail_list td{
  padding: 3px !important;
  }
  #Avail_Action{
  width: 20% !important;
  }
  #avail_table th{
  font-size: 6.5px !important;
  padding: 10px 0px !important;
  font-family: system-ui;
  }
  .Avail_action{
  padding:10px 0px !important;
  }
  .Avail_action input{
  font-size:6px !important;
  width: 44px !important;
  height: 20px !important;
  padding: 2px !important;
  }
  .UIOff{
  width:200px !important;
  }
}
</style>

<!-- code for processing vouchers -->
<script>
	var app = angular.module("myApp", []);
	
	
	let refId = "";
	let offerID = "";
	
	
	app.controller("myCtrl", function($scope,$http) {
	  $scope.voucherData = [];
	  $scope.usedVoucherData=[];
	  $scope.expiredVoucherData=[];
	  $scope.offersData = [];
	  
	  
	  //fetch voucher Start
	$scope.getVouchers = function() {

    var chkbx = document.getElementsByName('checkbox');

    var arrAmounts = [];
    var arrNos = 0;

    for (var a = 0; a < chkbx.length; a++) {
        if (chkbx[a].checked) {
            var c = a + 1;
            var t = document.getElementById('myTable');
            if (!t) {
                console.warn("myTable not found");
                continue;
            }

            var cell = t.rows.item(c).cells;
            var cellVal = parseFloat(cell.item(3).innerHTML);
            arrAmounts[arrNos] = cellVal;
            arrNos++;
        }
    }

    var Reservation_Status = $("#Reservation_status_").val();
    if (parseInt(arrNos) <= 0 && Reservation_Status === "CHECKED IN") {
        var modal = document.getElementById('modalVoucherDisplay');
        if (modal) modal.style.display = "none";
        $.alert("Please choose the window to proceed with the Voucher Availment");
        return;
    }

    var modal = document.getElementById('modalVoucherDisplay');
    var loading = document.getElementById('loadingUIHoverVoucher');
    var lbl = document.getElementById('lblUIHoverVoucher');

    if (modal) modal.style.display = "none";
    if (loading) loading.style.display = "block";
    if (lbl) lbl.innerHTML = "Fetching vouchers...";

    var data = {
        ReservId: '<%=request.getParameter("ReservId")%>'
    };

    $http({
        url: "GetVouchersDataServlet",
        method: "POST",
        params: data
    }).then(function(response) {

        var resp1 = JSON.stringify(response.data);

        // example of error handling
        if (1 == 2) { // replace with real condition if needed
            var resp = JSON.parse(resp1);
            var status = resp.CustomStatus;
            var msg = resp.MSG;

            if (modal) modal.style.display = "block";
            if (loading) loading.style.display = "none";

            var divError = document.getElementById('divVoucherError');
            var tblVouchers = document.getElementById('tblVouchers');
            if (divError) divError.style.display = "block";
            if (tblVouchers) tblVouchers.style.display = "none";

            return;
        }

        var divError = document.getElementById('divVoucherError');
        if (divError) divError.style.display = "none";

        var tableSelect = document.getElementById('VochersSelect')?.value || '';

        // hide/show tables safely
        var tblVoucher = document.getElementById('tblVoucher');
        var tblVouchers = document.getElementById('tblVouchers');
        var usedVocher = document.getElementById('UsedVocher');
        var usedVochers = document.getElementById('UsedVochers');
        var expiredVocher = document.getElementById('ExpiredVocher');
        var expiredVochers = document.getElementById('ExpiredVochers');

        if (tableSelect === 'Used') {
            if (tblVoucher) tblVoucher.style.display = "none";
            if (tblVouchers) tblVouchers.style.display = "none";
            if (usedVocher) usedVocher.style.display = "table";
            if (usedVochers) usedVochers.style.display = "table";
            if (expiredVocher) expiredVocher.style.display = "none";
            if (expiredVochers) expiredVochers.style.display = "none";

        } else if (tableSelect === 'Expired') {
            if (tblVoucher) tblVoucher.style.display = "none";
            if (tblVouchers) tblVouchers.style.display = "none";
            if (usedVocher) usedVocher.style.display = "none";
            if (usedVochers) usedVochers.style.display = "none";
            if (expiredVocher) expiredVocher.style.display = "table";
            if (expiredVochers) expiredVochers.style.display = "table";

        } else if (tableSelect === 'Avalable') {
            if (tblVoucher) tblVoucher.style.display = "table";
            if (tblVouchers) tblVouchers.style.display = "table";
            if (usedVocher) usedVocher.style.display = "none";
            if (usedVochers) usedVochers.style.display = "none";
            if (expiredVocher) expiredVocher.style.display = "none";
            if (expiredVochers) expiredVochers.style.display = "none";
        }

        $scope.voucherData = response.data.AvailableVochers;
        $scope.usedVoucherData = response.data.UsedVochers;
        $scope.expiredVoucherData = response.data.ExpiredVochers;

        if (modal) modal.style.display = "block";
        if (loading) loading.style.display = "none";

    });

};

	  //fetch voucher End
	  //GRAVTY - OTP,PIN,CARD SWIPE BUTTONS - Start
	  $scope.GravtyButtonsDispaly = function(){
		  
		  document.getElementById('modalVoucherDisplay').style.display = "none";
		  document.getElementById('loadingUIHoverVoucher').style.display = "block";
		  document.getElementById('lblUIHoverVoucher').innerHTML = "Fetching vouchers...";
		  
		  var data = {
				  ReservId:'<%=request.getParameter("ReservId")%>'
				};
		  
		  $http({
		      url: "GetVouchersDataServlet",
		      method: "POST",
		      params: data
		    }).
		  then(function(response) {
			  
			  var resp1 = JSON.stringify(response.data);
			  if(1==2)//(resp1.indexOf('CustomStatus') != -1)
			  {
				  var resp = JSON.parse(resp1);
				  var status = resp.CustomStatus;
				  var msg = resp.MSG;
				  
				  document.getElementById('modalVoucherDisplay').style.display = "block";
				  document.getElementById('loadingUIHoverVoucher').style.display = "none";
				  
				  document.getElementById('divVoucherError').style.display = "block";
				  document.getElementById('tblVouchers').style.display = "none";
				  
				  return;
			  }
			  
			  document.getElementById('divVoucherError').style.display = "none";
			  document.getElementById('tblVouchers').style.display = "table";
			  
			  $scope.voucherData = response.data.AvailableVochers;
			  $scope.usedVoucherData = response.data.UsedVochers;
			  $scope.expiredVoucherData = response.data.ExpiredVochers;
			  
			  document.getElementById('modalVoucherDisplay').style.display = "block";
			  document.getElementById('loadingUIHoverVoucher').style.display = "none";
			  
		  });
	  }
		//GRAVTY - OTP,PIN,CARD SWIPE BUTTONS - end
	  
	//avail voucher - Confirm Start
	  $scope.availVoucher = function(str){
		 
		  //code for confirmation before availing voucher - not using
		 /* $.confirm({
			    title: 'Confirm!',
			    content: 'Do you really want to avail the voucher:<br/><b>' + str + '</b>',
			    buttons: {
			        confirm: function () {
			        	$scope.availVoucherAPI(str);
			        },
			        cancel: function () {
			            $.alert('Operation cancelled!');
			        }
			    }
			}); */
			

			
			//code for displaying pop-up for card swipe authentication - to be used
		  $.confirm({
			    title: 'Authentication',
			    content: '' +
			    '<form action="" class="formName">' +
			    '<div class="form-group">' +
			    'Please swipe membership card' +
			    '<input type="password" class="voucherMemberCardSwipe form-control" required />' +
			    '</div>' +
			    '</form>',
			    buttons: {
			        formSubmit: {
			            text: 'Proceed',
			            btnClass: 'btn-blue',
			            action: function () {
			            				            	
			                var CardNumber = this.$content.find('.voucherMemberCardSwipe').val();
			                
							//if didn't swiped and clicked on submit
			                if(!CardNumber){
			                    $.alert('Membership swipe required');
			                    return false;
			                }
							//upon successfully swipe, call java class to validate the card
							var data = {
									  GlobalReservationNumber:'<%=request.getParameter("ReservId")%>', 
									  SwipedFor:'Vouchers', 
									  CardNumber:CardNumber,
									  GlobalPropertyCode:'<%=request.getParameter("Property")%>'
									};
					  
						  $http({
						      url: "CardSwipeServlet",
						      method: "POST",
						      params: data
						    }).
							  then(function(response) {
								  
								
								  
								  var status = response.data.status;
								  
								  console.log(response.data);
								  
								  if(status === "SUCCESS")
								  {
									  $.alert(str);
									  $scope.availVoucherAPI(str);

								  } else if(status === "FAILED")
								  {
									  $.alert(response.data.statusMsg);
								  } else {
									  $.alert('Failed to avail voucher <br/>Please try again later');
								  }
								  
								  
							  });
			            }
			        },
			        cancel: function () {
			            $.alert('Operation Cancelled');
			        },
			    },
			    onContentReady: function () {
			        var jc = this;
			        this.$content.find('form').on('submit', function (e) {
			            // if the user submits the form by pressing enter in the field.
			            e.preventDefault();
			        });
			    }
			});
			
			
	  }
	//avail voucher - Confirm End

	// Memeber Type Drop Down List for Voucher List - Start
	$(document).ready(function () {
		var MemType = document.getElementById('MemType');
		var MemLevel = document.getElementById('MemLevel');		
		
    $(".clMemberType").on("change", function () {
        searchterm = $(this).val();  
        MemType.innerHTML ='';
        MemLevel.innerHTML ='';
        var tableSelect = document.getElementById('VochersSelect').value;
        
        //Display membership type and level - Start
        if (searchterm =='Epicure'){
        	//var EPIMemberNumber = $("#EPIMemberNumber").val();
        	//MemType.innerHTML =getProfileData.EPIMemberNumber;
        	MemType.innerHTML =$("#EPIMemberNumber").val();
        	MemLevel.innerHTML =$("#EPIMemberLevel").val();
        }
        if (searchterm == 'Chambers'){
        	MemType.innerHTML =$("#CHMemberNumber").val();
        	//var CHMemberNumber = $("#CHMemberNumber").val();
        	MemLevel.innerHTML =$("#CHMemberLevel").val();
        }
        if (searchterm == 'Taj Club'){
        	MemType.innerHTML ="Taj Club";
        	MemLevel.innerHTML ="Taj Club Level";
        }
      //Display membership type and level - End
        if (tableSelect =='Avalable'){
        $('#tblVouchers tbody tr').each(function () {                    
            var sel = $(this);
            var txt = sel.find('td:eq(0)').text();
            if (searchterm != 'all') {
                if (txt.indexOf(searchterm) === -1) {
                    $(this).hide();
                }
                else {
                    $(this).show();
                }
            }
            else
            {                       
                $('#tblVouchers tbody tr').show();
            }        
        });
        }
      
        else if (tableSelect == 'Expired'){
        	$('#ExpiredVochers tbody tr').each(function () {                    
                var sel = $(this);
                var txt = sel.find('td:eq(0)').text();
                if (searchterm != 'all') {
                    if (txt.indexOf(searchterm) === -1) {
                        $(this).hide();
                    }
                    else {
                        $(this).show();
                    }
                }
                else
                {                       
                    $('#UsedVochers tbody tr').show();
                }        
            });
        }
        else if (tableSelect == 'Used'){
        	$('#UsedVochers tbody tr').each(function () {                    
                var sel = $(this);
                var txt = sel.find('td:eq(0)').text();
                if (searchterm != 'all') {
                    if (txt.indexOf(searchterm) === -1) {
                        $(this).hide();
                    }
                    else {
                        $(this).show();
                    }
                }
                else
                {                       
                    $('#UsedVochers tbody tr').show();
                }        
            });
        }
        
    });
   
});
//updated code
document.getElementById('UsedVochers').style.display = "none";
document.getElementById('UsedVocher').style.display = "none";
//document.getElementById('ExpiredVochers').style.display = "none";
//document.getElementById('ExpiredVocher').style.display = "none";

//document.getElementById('billNo').style.display = "none";
//document.getElementById('usedAt').style.display = "none";
$scope.billNo="";
$scope.usedAt="";
$scope.hLocation="";

	$(document).ready(function () {	
    $(".VochersSelect").on("change", function () {
        searchterm = $(this).val();  
        
        
        //Display used vochers
        if (searchterm =='Used'){
        	document.getElementById('tblVoucher').style.display = "none";
			document.getElementById('tblVouchers').style.display = "none";
			document.getElementById('ExpiredVochers').style.display = "none";
			document.getElementById('ExpiredVocher').style.display = "none";
			document.getElementById('UsedVochers').style.display = "table";
			document.getElementById('UsedVocher').style.display = "table";			
        }
        if (searchterm =='Expired'){
        	document.getElementById('tblVoucher').style.display = "none";
			document.getElementById('tblVouchers').style.display = "none";
			document.getElementById('ExpiredVochers').style.display = "table";
			document.getElementById('ExpiredVocher').style.display = "table";
			document.getElementById('UsedVochers').style.display = "none";
			document.getElementById('UsedVocher').style.display = "none";
        }
        if (searchterm == 'Avalable'){
        	document.getElementById('tblVoucher').style.display = "table";
			document.getElementById('tblVouchers').style.display = "table";
			document.getElementById('UsedVocher').style.display = "none";
			document.getElementById('UsedVochers').style.display = "none";
			document.getElementById('ExpiredVochers').style.display = "none";
			document.getElementById('ExpiredVocher').style.display = "none";
        }   
    });
   
});
//updated code end
	 $scope.btnGetBillData = function(memberId,memberType,AvailmentBitId){
		   
		  const data = {
				  
				  BitId:AvailmentBitId,
				  memberId:memberId,
				  memberType:memberType
				};
		  
		  $http({
		      url: "GetBillDataServlet",
		      method: "POST",
		      params: data
		    }).
		  then(function(response) {
			  
			  $scope.billNo=response.data.BillNumber;
			  $scope.usedAt=response.data.SponsorName;
			  $scope.hLocation=response.data.HotelLocation;
			  //$scope.hLocation = "test";
			  //location
			  if($scope.hLocation != ""){
				  document.getElementById('hLoc').innerHTML = " - " + $scope.hLocation;
				  }
			  document.getElementById('btnGetBillData').style.display = "none";
			  document.getElementById('billNo').style.display = "inline";
			  document.getElementById('usedAt').style.display = "inline";
			  //document.getElementById('tmpcss').style.text-align  = "left";
			  
		  });  

		
	  }
//updated code end2
	
	// Memeber Type Drop Down List for Voucher List - End
	
	
	//Avail privilage 3 buttons (OTP, PIN,Card Swipe)view start
	  $scope.AvailVoucherGravty = function(str, Memtype){	
		  
		//$('#modalOTP').show();

		
/* 		 var  VoucherDetails={VoucherCode:str};
	  		  

	var VoucherCode =VoucherDetails.VoucherCode;
		
	VoucherPinGravty */
	 $("#VoucherPinGravty").val(str);
	$("#Memtype").val(Memtype);
	// sending voucher Number value to hidden input 
	//alert($("#VoucherPinGravty").val());

	     
	  
	   

	       /* var tempTotalAmount = document.getElementById('txtTotalAmount').value;
	       
	       if (tempTotalAmount === "" || tempTotalAmount === null || tempTotalAmount === "0" || tempTotalAmount === "0.00") {
	           $.alert("Invalid amount entered");
	           return;
	       } */	       	     
	  
	       
	       //$.alert(payTypeVal);
	       //pay by TIC Points
	       //TCP vocher redeem - Start
				//	alert(Memtype);	       
				if(Memtype=="TCP"){
				//	$("#DivLoading").load("loadingAnimation.html");
					
			//		document.getElementById('DivLoading').style.display = "block";
					
					  document.getElementById('loadingUIHoverOffers').style.display = "block";
					  document.getElementById('lblUIHoverOffers').innerHTML = "Loading";
					// document.getElementById('GravtyloadingUIHover').style.display = "block";				
					var CardNo = document.getElementById('GravtytxtMemberCardNumberHidden').value;
			//		var VoucherCode = $("#VoucherPinGravty").val();
					var confirmationNo = document.getElementById('confNumber').value; 
					$.ajax({
	                     url: 'GravtyAvailPrivilageServlet',
	                     cache: false,
	                     type: "POST",
	                     data: {          
	                    	 Type:"TCP",
	                    	 InvoiceNo : 2,
	                    	 confirmationNo : confirmationNo,
	                         CardNumber: CardNo   ,   
	                         VoucherCode: str,
	                         Memtype:Memtype,
	                         GlobalReservationNumber:'<%=request.getParameter("ReservId")%>',
		                         GlobalPropertyCode: '<%=request.getParameter("Property")%>'
	                     },
	                     success : function(responseText) {
	                     	document.getElementById('GravtyGCloadingUIHover').style.display = "none";
	                       //  window.location=responseText;
	                      // alert(responseText);
	               //   	   redirectToNewInovices(responseText);
	               
	                     	var resp = JSON.parse(responseText);
	      	        	   
	      	        	   var status = resp.status;
	      	        	   var url = resp.url;
	      	        	 var msg = resp.msg;
	      	        	 if(status==="SUCCESS"){        
	           	        		//document.getElementById('GravtyloadingUIHover').style.display = "none"; 
	           	        		//document.getElementById('loadingUI').style.display = "none";
	           	        		document.getElementById('loadingUIHoverOffers').style.display = "none";
	           	        		
	                           	//document.getElementById('DivLoading').style.display = "none";
	                               //window.location=responseText;
	                        	//   redirectToNewInovices(url);
	          	  //      		setTimeout(function(){ $.alert("Sucessfully Availed. Navigating to Home Page"); }, 1000);            	        		
	          	 
	          	     //   		setTimeout(function(){ redirectToNewInovices(url);  }, 6000);
	           	 //       		$("#RedirectUrl").val(url);
	          	        	//	document.getElementById('GravtymodalBodyPIN').style.display = "none";
	          	        	
	          	        	$("#RedirectUrl").val(url);                     	        		
                     	        		$('#GravtymodalOTP').modal({
                 	                       backdrop: 'static',
                 	                       keyboard: false,
                 	                   });
                     	        document.getElementById('GravtymodalBodyVerificationType').style.display = "none";
	          	        		document.getElementById('GravtymodalUrlRedirect').style.display = "block";
	          	        		
	           	        	   }      	        		  
	           	        	   else
	           	        		{
	           	        		  $.alert(msg);
	           	        		document.getElementById('GravtyloadingUIHover').style.display = "none";
	           	        		document.getElementById('loadingUI').style.display = "none";
	                	        	// redirectToNewInovices(responseText);
	           	        		}
	                     },
	                     error: function(errMsg){
	                     	//document.getElementById('DivLoading').style.display = "none";
	                     	//$.alert("An error occured: " + errMsg.status + " " + errMsg.statusText);
	                     	alert("failed");
	                     },
	                     dataType: "text"
	                 });
					
	}

					//TCP vocher redeem - End   
	       
	   
	      	        if($('#GravtymodalOTP').is(":visible"))
	               {
	                   var jsonStr = JSON.stringify(arr);
	                   
	                   if($('#GravtymodalBodyCardSwipe').is(":visible")){
	                	   cardSwipePayment(jsonStr, "TIC", totalAmount, TICPoints, "Points");
	                   }
	                   
	                   else if($('#GravtymodalBodyOTP').is(":visible")){
	                	   validateOTP(jsonStr, "TIC", totalAmount, TICPoints, "Points");
	                   }
	                   
	                   
	               }
	      	      else if(Memtype=="TCP"){
               	   
                  }
	      	        else{
	   
	                   $('#GravtymodalOTP').modal({
	                       backdrop: 'static',
	                       keyboard: false,
	                   });
	   
	               }
	      	  
	       
	       
	   
	   <%--          else if (payTypeVal == "card") {
	   
	               var CardNo = document.getElementById('txtCardNo').value;
	               var CardPin = document.getElementById('txtCardPin').value;
	               var CardAmount = document.getElementById('txtCardAmount').value;
	   				
	              // $.alert(CardAmount);
	               
	               if ((CardNo == null || CardNo == "") || (CardPin == null || CardPin == "")) {
	                   $.alert("Card Details Required!");
	                   return;
	               } else if(CardAmount == null || CardAmount == "" || parseFloat(CardAmount) <= 0){
	   
	                   $.alert("Invalid Amount Entered");
	                   return;
	   
	               } else if (parseFloat(CardAmount) > totalAmountChecked) {
	                   $.alert("Invalid Amount Entered");
	                   return;
	               }
	               else
	               {
	                   $("#DivLoading").load("loadingAnimation.html");
	   
	                   var jsonStr = JSON.stringify(arr);
	   
	                   $(document).ready(function () {
	                       $.ajax({
	                           url: 'ProcessInvoices',
	                           cache: false,
	                           type: "POST",
	                           data: {
	                               InvoiceNo: jsonStr,
	                               Type: "QGC",
	                               Amount: CardAmount,
	                               CardNumber: CardNo,
	                               CardPin: CardPin,
	                               PaymentType: "GiftCard",
	                               GCPayType: "Number",
	                               GlobalReservationNumber:'<%=request.getParameter("ReservId")%>'
	                           },
	                           success : function(responseText) {
	                           	//document.getElementById('DivLoading').style.display = "none";
	                               //window.location=responseText;
	                        	   redirectToNewInovices(responseText);
	                           },
	                           error: function(errMsg){
	                           	document.getElementById('DivLoading').style.display = "none";
	                           	//$.alert("An error occured: " + errMsg.status + " " + errMsg.statusText);
	                           },
	                           dataType: "text"
	                       });
	                   });
	   
	               }
	   
	           } --%> 	       
	   
		
	}
	
	
	
	//Avail privilage 3 buttons (OTP, PIN,Card Swipe)view end
	  
	  //avail voucher -- call API Start
	  $scope.availVoucherAPI = function(str){
		  
		  document.getElementById('modalVoucherDisplay').style.display = "none";
		  document.getElementById('loadingUIHoverVoucher').style.display = "block";
		  document.getElementById('lblUIHoverVoucher').innerHTML = "Availing voucher...";
		  
		  var data = {
						  ReservId:'<%=request.getParameter("ReservId")%>', 
						  PropertyCode:'<%=request.getParameter("Property")%>', 
						  VoucherNumber:str
						};
		  
		  $http({
		      url: "AvailVoucherServlet",
		      method: "POST",
		      params: data
		    }).
		  then(function(response) {
			  
			  document.getElementById('modalVoucherDisplay').style.display = "block";
			  document.getElementById('loadingUIHoverVoucher').style.display = "none";
			  
			  var status = response.data.status;
			  
			  if(status === "SUCCESS")
			  {
				  $.alert(response.data.msg);
				  
				  $scope.getVouchers();
				  
				 // $scope.postVoucherPMS(str);
			  } else if(status === "ERROR")
			  {
				  $.alert(response.data.msg);
			  } else {
				  $.alert('Failed to avail voucher <br/>Please try again later');
			  }
			  
			  
		  });
	  }
	//avail voucher -- call API End
	
	  /* PMS Voucher Post Start */
	  
		$scope.postVoucherPMS = function(voucherNumber){
		
		      document.getElementById('modalVoucherDisplay').style.display = "none";
			  document.getElementById('loadingUIHoverVoucher').style.display = "block";
			  document.getElementById('lblUIHoverVoucher').innerHTML = "Posting to PMS...";
		
		  var data = {
				  ReservId:'<%=request.getParameter("ReservId")%>',
				  PropertyCode:'<%=request.getParameter("Property")%>', 
				  VoucherNumber:voucherNumber
				};
		  
		  $http({
		      url: "PostVoucherServlet",
		      method: "POST",
		      params: data
		    }).
		  then(function(response) {
			
			  document.getElementById('modalVoucherDisplay').style.display = "block";
			  document.getElementById('loadingUIHoverVoucher').style.display = "none";
			  
			  var status = response.data.status;
			  
			  if(status === "SUCCESS")
			  {
				  $scope.getVouchers();
			  } else if(status === "ERROR")
			  {
				  $.alert(response.data.msg);
			  } else {
				  $.alert('Failed to avail voucher <br/>Please try again later');
			  }
			 
		  });
	  }
	  
	  /* PMS Voucher Post End */	  	  
		
	  /* TCP OTP Start */
	  
	  	
$scope.TCPenableOtpBody = function(ID,memtype)
{
	document.getElementById('loadingUIHoverOffers').style.display = "block";
	document.getElementById('lblUIHoverOffers').innerHTML = "Sending OTP..."
	//document.getElementById('GravtymodalBodyVerificationType').style.display = "none";
	//document.getElementById('GravtyloadingUIHover').style.display = "block";
	//var Memtype = $("#Memtype").val();
		offerID = ID;
	    $.ajax({
                     url: 'TCPSendOTP',
                     cache: false,
                     type: "POST",
                     data: {                              	
                         ReservId:'<%=request.getParameter("ReservId")%>'
                     },
                     success : function(responseText) {

      	        	 var resp = JSON.parse(responseText);
      			   
      			   var status = resp.status;
      			 refId = resp.id;
      			   
      			   let mobile  = resp.mobile;
      			   
      	        	   
      	        	 if(status==="Success"){
      	        		document.getElementById('loadingUIHoverOffers').style.display = "none";
      	        		$.alert("Otp sent sucessfully to Mobile :"+mobile);
      	        		//document.getElementById('GravtyloadingUIHover').style.display = "none";
      	        		//document.getElementById('GravtymodalBodyOTP').style.display = "block";
      	        		//document.getElementById('GravtymodalBodyCardSwipe').style.display = "none";
      	        		document.getElementById('TCPmodalOTP').style.display = "block";
      	        		document.getElementById('TCPmodalBodyOTP').style.display = "block";
      	        		document.getElementById('TCPOTP').focus();
      	        		//otp count down not using
      	        	/*	var timeleft = 600;
      	        		var downloadTimer = setInterval(function(){
      	        		  if(timeleft <= 0){
      	        		    clearInterval(downloadTimer);
      	        		    document.getElementById("TCPcountdown").innerHTML = "OTP Expired, Click Resend OTP.";
      	        		  } else {
      	        		    document.getElementById("TCPcountdown").innerHTML = timeleft + " seconds remaining.";
      	        		  }
      	        		  timeleft -= 1;
      	        		}, 1000);  */
      	        	//otp count down - End
      	        	   }      	        		  
      	        	   else
      	        		{
      	        		  $.alert(status);
      	        		
      	        		}
                     },
                     error: function(errMsg){
                     	//document.getElementById('DivLoading').style.display = "none";
                     	//$.alert("An error occured: " + errMsg.status + " " + errMsg.statusText);
                     	alert("failed");
                     },
                     dataType: "text"
                 }); 
	  
	//alert("Otp sent sucessfully"); 
	   
	   
}


/* validate OTP start */
 

 
 
/* Validate OTP end */
	  /* TCP OTP end */
		/* Get Offers Data Start */
		  
		 $scope.getOffers = function(){
			  document.getElementById('modalOffersDisplay').style.display = "none";
			  document.getElementById('loadingUIHoverOffers').style.display = "block";
			  document.getElementById('lblUIHoverOffers').innerHTML = "Fetching offers";
			  
			  var data = {
					  ReservId:'<%=request.getParameter("ReservId")%>'
					};
			  
			  $http({
			      url: "GetOffersDataServlet",
			      method: "POST",
			      params: data
			    }).
			  then(function(response) {
				  
				  
				  //var resp1 = JSON.stringify(response.data);
				  //if(resp1.indexOf('CustomStatus') != -1)//old code
				  
				  if(response.data.length == 0)
				  {
					  //var resp = JSON.parse(resp1);
					  //var status = resp.CustomStatus;
					 // var msg = resp.MSG;
					  
					  document.getElementById('modalOffersDisplay').style.display = "block";
					  document.getElementById('loadingUIHoverOffers').style.display = "none";
					  
					  document.getElementById('divOffersError').style.display = "block";
					  document.getElementById('tblOffers').style.display = "none";
					  
					  return;
				  }
				  
				  document.getElementById('divOffersError').style.display = "none";
				  document.getElementById('tblOffers').style.display = "table";
				  
				  $scope.offersData = response.data;
				  
				  document.getElementById('modalOffersDisplay').style.display = "block";
				  document.getElementById('loadingUIHoverOffers').style.display = "none";
				  
			  });
		  }
	  
	  /* Get Offers Data End */
	  
	  /* CCAvanue handler start */
	  
	 $scope.ccAvenueHandler = function(action){
		  
		 var data = {
				  ReservId:'<%=request.getParameter("ReservId")%>',
				  reqType:action
				};
		 
		 $http({
		      url: "CCAvenueHandler",
		      method: "POST",
		      params: data
		    }).
		  then(function(response){
			 
			  $.alert(response.data);
			  
			 
		  });
		  
	  }
	  
	 /* CCAvanue handler end */
	  
	});
	/* validate OTP start */
	function ValidateRedeem(){
		 document.getElementById('TCPloadingUIHover').style.display = "block";
			  document.getElementById('TCPlblUIHover').innerHTML = "Validating OTP...";
		//document.getElementById('GravtymodalBodyVerificationType').style.display = "none";
		//document.getElementById('GravtyloadingUIHover').style.display = "block";
		//var Memtype = $("#Memtype").val();
		let otp = document.getElementById('TCPOTP').value;
		
		if(otp === ""){
			document.getElementById('TCPloadingUIHover').style.display = "none";
			$.alert("Please enter OTP");
			return;
		}
		
		    $.ajax({
	                     url: 'TCPValidateRedeem',
	                     cache: false,
	                     type: "POST",
	                     data: {                              	
	                         ReservId:'<%=request.getParameter("ReservId")%>',
							 RefID:refId,
							 OTP:otp,
							 offerId:offerID
							 
	                     },
	                     success : function(responseText) {

	      	        	 var resp = JSON.parse(responseText);
	      			   
	      			   var status = resp.status;
	      			   
	      			   
	      			   
	      			   
	      			 document.getElementById('TCPloadingUIHover').style.display = "none";
	      	        	 if(status==="successfull"){
	      	        		document.getElementById('TCPmodalOTP').style.display = "none";
	      	        		document.getElementById('TCPmodalBodyOTP').style.display = "none";
	      	        		
	      	        		document.getElementById('TCPOTP').value = "";
	      	        		 $.alert("OFFER Redeemed sucessfully");
	      	        		//document.getElementById('modalOffersMain').style.display = "none";
	      	        		document.getElementById("closebtn").click();
	      	        		 //$.alert("Otp sent sucessfully");
	      	        		//document.getElementById('GravtyloadingUIHover').style.display = "none";
	      	        		//document.getElementById('GravtymodalBodyOTP').style.display = "block";
	      	        		//document.getElementById('GravtymodalBodyCardSwipe').style.display = "none";

	      	        	   }      	        		  
	      	        	   else
	      	        		{
	      	        		  $.alert(status);
	      	        		document.getElementById('TCPOTP').value = "";
	      	        		
	      	        		}
	                     },
	                     error: function(errMsg){
	                     	//document.getElementById('DivLoading').style.display = "none";
	                     	//$.alert("An error occured: " + errMsg.status + " " + errMsg.statusText);
	                     	document.getElementById('TCPloadingUIHover').style.display = "none";
	                     	document.getElementById('TCPOTP').value = "";
	                     	alert("OTP validation failed");
	                     	
	                     },
	                     dataType: "text"
	                 }); 
		  
		//alert("Otp sent sucessfully"); 
		   
		   
	}
	/* Validate OTP end */
</script>

<script type="text/javascript">
	window.onload = function()
	{ 
	//	document.getElementById("welcomeLoading").style.display = "none" 
	}
</script>


<!-- enableCardSwipeBody() -->
<script type="text/javascript">
function enableCardSwipeBody()
{
	  // $.alert("Hi");
document.getElementById('modalBodyOTP').style.display = "none";
document.getElementById('modalBodyCardSwipe').style.display = "block";
document.getElementById('modalBodyVerificationType').style.display = "none";
document.getElementById('txtMemberCardNumberHidden').focus();
}
</script>


<!-- Script for Giftcard Swipe -->

<!-- GravtyenableCardSwipeBody() Start-->
<script type="text/javascript">
function GravtyenableCardSwipeBody()
{
	   //$.alert("Hi");
document.getElementById('GravtymodalBodyOTP').style.display = "none";
document.getElementById('GravtymodalBodyCardSwipe').style.display = "block";
document.getElementById('GravtymodalBodyVerificationType').style.display = "none";
document.getElementById('txtMemberCardNumberHidden').focus();
}
</script>
<!-- GravtyenableCardSwipeBody() End-->

<!-- GravtyenableOtpBody() Start-->
<script type="text/javascript">
function GravtyenableOtpBody()
{
	   //$.alert("Hi");
	//   document.getElementById('loadingUIHoverVoucher').style.display = "block";
	document.getElementById('GravtymodalBodyVerificationType').style.display = "none";
	document.getElementById('GravtyloadingUIHover').style.display = "block";
	var Memtype = $("#Memtype").val();
	    $.ajax({
                     url: 'GravtySendOtpServlet',
                     cache: false,
                     type: "POST",
                     data: {                              	
                         Memtype:Memtype
                       
                     },
                     success : function(responseText) {
                     	//document.getElementById('DivLoading').style.display = "none";
                       //  window.location=responseText;
                     //  alert(responseText);
                  	  //
                     //	var resp = JSON.stringify(responseText);
      	        	   
      	        	//   var status = resp;
      	        	 var resp = JSON.parse(responseText);
      			   
      			   var status = resp.status;
      			   var mobile = resp.mobile;
      			   var email = resp.email;
      			   
      			   
      	        	   
      	        	 if(status==="Success"){
      	        		 $.alert("Otp sent sucessfully to Mobile :"+mobile+" \n   and  \nEmail :"+email);
      	        		 //$.alert("Otp sent sucessfully");
      	        		document.getElementById('GravtyloadingUIHover').style.display = "none";
      	        		document.getElementById('GravtymodalBodyOTP').style.display = "block";
      	        		document.getElementById('GravtymodalBodyCardSwipe').style.display = "none";
      	        		document.getElementById('GravtymodalBodyVerificationType').style.display = "none";
      	        		document.getElementById('txtOTP').focus();
      	        		//otp count down
      	        		var timeleft = 600;
      	        		var downloadTimer = setInterval(function(){
      	        		  if(timeleft <= 0){
      	        		    clearInterval(downloadTimer);
      	        		    document.getElementById("countdown").innerHTML = "OTP Expired, Click Resend OTP.";
      	        		  } else {
      	        		    document.getElementById("countdown").innerHTML = timeleft + " seconds remaining.";
      	        		  }
      	        		  timeleft -= 1;
      	        		}, 1000);
      	        	//otp count down - End
      	        	   }      	        		  
      	        	   else
      	        		{
      	        		  $.alert(status);
      	        		document.getElementById('GravtyloadingUIHover').style.display = "none";
      	        		 document.getElementById('GravtymodalBodyOTP').style.display = "none";
      	               document.getElementById('GravtymodalBodyCardSwipe').style.display = "none";
      	               document.getElementById('GravtymodalBodyPIN').style.display = "none";
      	               document.getElementById('GravtymodalBodyVerificationType').style.display = "block";
      	               document.getElementById('txtMemberCardNumberHidden').value = "";
      	               document.getElementById('txtOTP').value = "";
      	               document.getElementById('GravtymodalManualMemberNumberBody').style.display = "none";
      	               document.getElementById('txtOtpMemberNumber').value = "";
      	        		}
                     },
                     error: function(errMsg){
                     	//document.getElementById('DivLoading').style.display = "none";
                     	//$.alert("An error occured: " + errMsg.status + " " + errMsg.statusText);
                     	alert("failed");
                     },
                     dataType: "text"
                 }); 
	  
	//alert("Otp sent sucessfully"); 
	   
	   
}
</script>
<!-- GravtyenableOtpBody() End-->
<script type="text/javascript">
function GravtyenablePINBody()
{
	   //$.alert("Hi");
document.getElementById('GravtymodalBodyOTP').style.display = "none";
document.getElementById('GravtymodalBodyPIN').style.display = "block";
document.getElementById('GravtymodalBodyCardSwipe').style.display = "none";
document.getElementById('GravtymodalBodyVerificationType').style.display = "none";
document.getElementById('txtMemberCardNumberHidden').focus();
}
function AlertMessage(msg){
$.alert(msg);
}
</script>
<script type="text/javascript">
    function cardSwipedGC()
    {
    	var arrAmounts = [];
	    var arr = [];
	    var arrNo = 0;
	    var chkbx = document.getElementsByName('checkbox');
	    var totalAmountChecked = 0;
	
	    for (a = 0; a < chkbx.length; a++) {
	       var ifChk = chkbx[a].checked;
	
	       if (ifChk) {
		       var c = a + 1;
		       var t = document.getElementById('myTable');
	
		       var cell = t.rows.item(c).cells;
		       var cellInv = cell.item(1).innerHTML;
		       var cellAmount = cell.item(3).innerHTML;
	
		       arr[arrNo] = cellInv;
		       arrAmounts[arrNo] = cellAmount;
		       arrNo++;
	
	       }
        }   
	    
        var cardNumberSwipe = document.getElementById('txtGCCardNumber').value;
        var amount = document.getElementById('txtGiftCardAmount').value;
        var invoiceNo = JSON.stringify(arr);
        
        document.getElementById('lblUIHoverGC').innerHTML = "Validating giftcard...";
        document.getElementById('modalGCBodyCardSwipe').style.display = "none";
        document.getElementById('loadingUIHoverGC').style.display = "block";
        
        $(document).ready(function() {
        	   $.ajax({
        		   url : 'GiftCardSwipeServlet',
        		   cache: false,
        		   data: {
        			   txtCardSwipe: cardNumberSwipe      	
        		   },
        		   success : function(responseText) {
        			   
        			   document.getElementById('modalGCBodyCardSwipe').style.display = "block";
        		        document.getElementById('loadingUIHoverGC').style.display = "none";

        			   var resp = JSON.parse(responseText);
        			   
        			   var status = resp.STATUS;
        			   var cardNumber = resp.CardNumber;
        			   var trackData = resp.TrackData;
        			   
        				if(status === "SUCCESS")
        				{
        					document.getElementById('lblUIHoverGC').innerHTML = "Processing payment...";
        					document.getElementById('modalGCBodyCardSwipe').style.display = "none";
        			        document.getElementById('loadingUIHoverGC').style.display = "block";
        					
        					$(document).ready(function () {
        						   $.ajax({
        							   url: 'ProcessInvoices',
        							   cache: false,
        							   type: "POST",
        							   data: {
        								   InvoiceNo: invoiceNo,
        								   Type: "QGC",
        								   Amount: amount,
        								   CardNumber: cardNumber,
        								   TrackData: trackData,
        								   PaymentType: "GiftCard",
        								   GCPayType: "Swipe",
        								   GlobalReservationNumber:'<%=request.getParameter("ReservId")%>'
        							   },
        							   success : function(responseText) {
        								//document.getElementById('DivLoading').style.display = "none";
        								   //window.location=responseText;
        								   redirectToNewInovices(responseText);
        							   },
        							   error: function(errMsg){
        								document.getElementById('DivLoading').style.display = "none";
        								//$.alert("An error occured: " + errMsg.status + " " + errMsg.statusText);
        							   },
        							   dataType: "text"
        						   });
        						});
        					
        				} else if(status === "ERROR")
        				{
        					$.alert("unable to read the card \n please try again later");
        					document.getElementById('txtGCCardNumber').value = "";
        				}
        		   },
        		   error: function(errMsg){
        			$.alert("unable to read the card \n please try again later");
        			document.getElementById('txtGCCardNumber').value = "";
        		   },
        		   dataType: "text"
        	   });
        	}); 
        
    }

    function enableGCSwipemodal()
    {
        //$('#modalGC').modal('toggle');

        var amount = document.getElementById('txtGiftCardAmount').value;

        var arrAmounts = [];
	    var arr = [];
	    var arrNo = 0;
	    var chkbx = document.getElementsByName('checkbox');
	    var totalAmountChecked = 0;
	
	    for (a = 0; a < chkbx.length; a++) {
	       var ifChk = chkbx[a].checked;
	
	       if (ifChk) {
		       var c = a + 1;
		       var t = document.getElementById('myTable');
	
		       var cell = t.rows.item(c).cells;
		       var cellInv = cell.item(1).innerHTML;
		       var cellAmount = cell.item(3).innerHTML;
	
		       arr[arrNo] = cellInv;
		       arrAmounts[arrNo] = cellAmount;
		       arrNo++;
	
	       }
        }

        if (arr.length > 0) {
            for (var i = 0; i < arrAmounts.length; i++)
                totalAmountChecked = totalAmountChecked + parseFloat(arrAmounts[i]).toFixed(2);

            if (amount === "" || amount === null || amount === "0") {
                $.alert("Invalid amount entered");
                return;

            } else if (parseFloat(amount) > parseFloat(totalAmountChecked)) {
                $.alert("Amount cannot be greater than total amount");
                return;
            }
            else {

            	
            	
                $('#modalGC').modal({
                    backdrop: 'static',
                    keyboard: false,
                    show: true
                });
                
                document.getElementById('txtGCCardNumber').focus();
            }

        } else
        {
            $.alert("Select invoice to proceed");
            return;
        }
	
	    
        
    }
    
    function GCSwipeMakePayment()
    {
    	$("#DivLoading").load("loadingAnimation.html");
    	   
        var jsonStr = JSON.stringify(arr);

        $(document).ready(function () {
            $.ajax({
                url: 'ProcessInvoices',
                cache: false,
                type: "POST",
                data: {
                    InvoiceNo: jsonStr,
                    Type: "QGC",
                    Amount: CardAmount,
                    CardNumber: CardNo,
                    CardPin: CardPin,
                    PaymentType: "GiftCard",
                    GlobalReservationNumber:'<%=request.getParameter("ReservId")%>'
                },
                success : function(responseText) {
                	//document.getElementById('DivLoading').style.display = "none";
                    //window.location=responseText;
                	redirectToNewInovices(responseText);
                },
                error: function(errMsg){
                	document.getElementById('DivLoading').style.display = "none";
                	//$.alert("An error occured: " + errMsg.status + " " + errMsg.statusText);
                },
                dataType: "text"
            });
        });
    }

    function GCSwipeGoBackBtn()
    {
        $('input[name=rdoPayType]').prop('checked', false);
        document.getElementById('txtGCCardNumber').value = "";
        document.getElementById('divGiftCardSwipe').style.display = "none";
        $('#modalGC').modal('toggle');
    }
</script>

<!-- Script for modal -->
<script type="text/javascript">

	//Script for validating the points in-page
	function validatePoints()
    {
        var pointType = document.querySelector('input[name="rdoPayType"]:checked').value;

        if (pointType === "tic") {

            var ticEntered = document.getElementById('txtTIC').value;
            var TICPoints = document.getElementById('txtTICPoints').value;

            if (parseInt(ticEntered) > parseInt(TICPoints)) {
                $.alert("Insufficient Member Point Balance \nAvailable points: \nTIC points:  " + TICPoints);
                return false;
            } else
                return true;

        } else
            return false;

    }

   //Script for managing the PayByPoint layout option's
   function enableOTPBody()
   {
	   if (validatePoints())
       {
          //document.getElementById('modalBodyCardSwipe').style.display = "none";
           //document.getElementById('modalBodyOTP').style.display = "block";
           //document.getElementById('modalBodyVerificationType').style.display = "none";
   
           //sendOTP();
       }
   }
   
   
 //code for managing the manual entry of membership number for sending OTP
   function enableManualMemberNumberBody()
   {
       document.getElementById('modalManualMemberNumberBody').style.display = "block";
       document.getElementById('txtOtpMemberNumber').focus();
       document.getElementById('modalBodyVerificationType').style.display = "none";
       document.getElementById('modalBodyCardSwipe').style.display = "none";
       
       var existingMemNum = document.getElementById('txtMemberNumber').value;
       var txtMemberNumberTIC = document.getElementById('TICMemberNumber').value;
       if (!(existingMemNum.trim() === "" || existingMemNum == null || existingMemNum === "Member Not Enrolled" || existingMemNum == "Member Not Enrolled"))
       {
           document.getElementById('txtOtpMemberNumber').value = txtMemberNumberTIC;
       }
   }

   function validateMemberAndSendOTP()
   {
       var MembershipNumber = document.getElementById('txtOtpMemberNumber').value;

       if (MembershipNumber == "" || MembershipNumber == null || MembershipNumber.trim() === "")
       {
           $.alert("Enter a valid membership number to proceed");
           return;
       } else
       {
    	   
    		
	           //loading UI - Please wait \n Retrieving membership information
	           //hide current layout & display loading layout
	           document.getElementById('lblUIHover').innerHTML = "Retrieving membership information";
	           document.getElementById('loadingUIHover').style.display = "block";
	           document.getElementById('modalManualMemberNumberBody').style.display = "none";
	
	           
	           $(document).ready(function () {
	               $.ajax({
	                   url: 'GetMembershipProfileInfo',
	                   cache: false,
	                   type: "POST",
	                   data: {
	                       MemberNumber: MembershipNumber,
	                       GlobalReservationNumber: '<%=request.getParameter("ReservId")%>',
	                       GlobalPropertyCode:'<%=request.getParameter("Property")%>'
	                   },
	                   success: function (responseText) {
	                	   
	                	   document.getElementById('loadingUIHover').style.display = "none";
	                       document.getElementById('modalManualMemberNumberBody').style.display = "block";
	
	                       //unhide the current layload
	                       //get the member information from the siebel service and call the send OTP service
	                       //hide the current layout & display the "Enter OTP" layout
	                       
	                       var resp = JSON.parse(responseText);
	                       
	                       var status = resp.STATUS;
	                       
	                       if(status === "SUCCESS")
	                   	   {
	                           var TcpCustomerHash = resp.TcpCustomerHash; 
	                          sendOTP(TcpCustomerHash);
	                           
	                   	   } else {
	                   		   $.alert("failed to retreive member information");
	                   		   return;
	                   	   }
	
	                   },
	                   dataType: "text"
	               });
	           });
       		
       }
   }
   

   
   
   function cardSwiped() {
	   
   var txtCardNumber = document.getElementById('txtMemberCardNumberHidden').value;
   var confirmationNumberDis = document.getElementById('labelConfirmationDisplay').value;
   var arrivalDis = document.getElementById('labelArrivalDisplay').value;
   var DepartureDis = document.getElementById('labelDepartureDisplay').value;
   //$.alert("Hello");
   
	var arrAmounts = [];
	var arr = [];
	var arrNo = 0;
	var chkbx = document.getElementsByName('checkbox');
	var totalAmountChecked = 0;
	
	for (a = 0; a < chkbx.length; a++) {
	   var ifChk = chkbx[a].checked;
	
	   if (ifChk) {
		   var c = a + 1;
		   var t = document.getElementById('myTable');
	
		   var cell = t.rows.item(c).cells;
		   var cellInv = cell.item(1).innerHTML;
		   var cellAmount = cell.item(3).innerHTML;
	
		   arr[arrNo] = cellInv;
		   arrAmounts[arrNo] = cellAmount;
		   arrNo++;
	
	   }
	}
	
	for (var i = 0; i < arrAmounts.length; i++)
		   totalAmountChecked = totalAmountChecked + parseFloat(arrAmounts[i]).toFixed(2);

		var payType = document.getElementsByName('rdoPayType');
		var payTypeVal;
		var payCount = 0;
		for (var i = 0; i < payType.length; i++) {
		   if (payType[i].checked) {
			   payTypeVal = payType[i].value;
			   payCount++;
		   }
		}
		
		
		var totalAmount = parseFloat(document.getElementById('txtTotalAmount').value).toFixed(2);
		var TICPoints = document.getElementById('txtTIC').value;
		var Points = "";
		
		if (totalAmount === "" || totalAmount === null || totalAmount === "0" || totalAmount === "0.00") {
            $.alert("Invalid amount entered");
            return;
		}
		
		if(payTypeVal === "tic")
		{
			Points = TICPoints;
		} 
	
		
	if (arr.length > 0) 
	{
		document.getElementById('lblUIHover').innerHTML = "Validating card...";
		document.getElementById('modalBodyCardSwipe').style.display = "none";
        document.getElementById('loadingUIHover').style.display = "block";
		
	  $(document).ready(function() {
	       $.ajax({
	           url : 'CardSwipeServlet',
	           cache: false,
	           data: {
	           	CardNumber: txtCardNumber,
	           	PointType: payTypeVal,
	           	Point: Points,
	           	confirmationNumberDis: confirmationNumberDis,
                arrivalDis: arrivalDis,
                DepartureDis: DepartureDis,
	           	SwipedFor:'Points', 
	           	GlobalReservationNumber:'<%=request.getParameter("ReservId")%>',
	           	GlobalPropertyCode:'<%=request.getParameter("Property")%>'
	           },
	           success : function(responseText) {
	        	   
	        	   document.getElementById('modalBodyCardSwipe').style.display = "block";
	               document.getElementById('loadingUIHover').style.display = "none";
	
	        	   var resp = JSON.parse(responseText);
	        	   
	        	   var status = resp.status;
	        	   
	        	    if(status === "SUCCESS")
	        		{
	        	    	//$.alert("success");
	        	    	
	        	    	if(payTypeVal === "tic")
	        			{
	        				payTypeVal = "TIC";
	        			} 
	        	    	
	        	    	document.getElementById('lblUIHover').innerHTML = "Processing payment...";
	        	    	document.getElementById('modalBodyCardSwipe').style.display = "none";
	                    document.getElementById('loadingUIHover').style.display = "block";
	        	    	
	        		   var CardNumber = resp.memberNumber;
	        		   var GlobalReservationNumber = '<%=request.getParameter("ReservId")%>';
	        		   
	        		   var invoiceNo = JSON.stringify(arr);
	        		   var otherMemberNumber = resp.memberNumber;
	        		   
	        		   var customerHash = resp.customerHash;
	        		   var tcpMemberNumber = resp.tcpMemberNumber;

	        		   $(document).ready(function () {
	        		     $.ajax({
	        		   	  url: 'SwipeRedeemServlet',
	        		   	  cache: false,
	        		   	  type: "POST",
	        		   	  data: {
	        		   		  customerHash: customerHash,
	        		   		  InvoiceNo: invoiceNo,
	        		   		  Type: payTypeVal,
	        		   		  Amount: totalAmount,
	        		   		  Points: Points,
	        		   		  PaymentType: 'Points',
	        		   		  MemberCardType: 'Swipe',
	        		   		  SwipeMemberNumber: txtCardNumber,
	        		   		  tcpMemberNumber: tcpMemberNumber,
	        		   		  confirmationNumberDis: confirmationNumberDis,
	        		   		  arrivalDis: arrivalDis,
	        		   		  DepartureDis: DepartureDis,
	        		   		  GlobalReservationNumber:'<%=request.getParameter("ReservId")%>',
	        		   		  GlobalPropertyCode:'<%=request.getParameter("Property")%>'
	        		   	  },
	        		   	success : function(responseText) {
	        		   		
	        		   		document.getElementById('DivLoading').style.display = "none";
	        		   		//window.location=responseText;
	        		   		redirectToNewInovices(responseText);
	        		   		
	        		   	},
	        		   	  dataType: "text"
	        		     });
	        		   });
	        		   
	        		   
	        		   
	        		}  else if(status === "ERROR")
	        		{
	        			var msg = resp.statusMsg;
	        			var tic = resp.TICPoints;
	        			document.getElementById('txtMemberCardNumberHidden').value = "";
	        			var txt = "" + msg + "\n\nAvailable points \nTIC: " + tic + "\n";
	        			$.alert(msg);
	        		} else if(status === "FAILED")
	        		{
	        			var msg = resp.statusMsg;
	        			$.alert(msg);
	        			document.getElementById('txtMemberCardNumberHidden').value = "";
	        		}
	           },
	           error: function(errMsg){
	           	$.alert("unable to read the card \n please try again later");
	           	document.getElementById('txtMemberCardNumberHidden').value = "";
	           },
	           dataType: "text"
	       });
	   }); 
  
	} else
	{
	   $.alert("Select Invoice to Proceed");
	   return;
	}
  
  
   }

   //GravtycardSwiped() Start
   	
   function GravtycardSwiped() {
	//alert("GravtycardSwiped");  
	   	
	   if($('#GravtymodalOTP').is(":visible"))
       {
           
		   var arrAmounts = [];
		    var arr = [];
		    var arrNo = 0;
		    var chkbx = document.getElementsByName('checkbox');
		    var totalAmountChecked = 0;
		
		    for (a = 0; a < chkbx.length; a++) {
		       var ifChk = chkbx[a].checked;
		
		       if (ifChk) {
			       var c = a + 1;
			       var t = document.getElementById('myTable');
		
			       var cell = t.rows.item(c).cells;
			       var cellInv = cell.item(1).innerHTML;
			       var cellAmount = cell.item(3).innerHTML;
		
			       arr[arrNo] = cellInv;
			       arrAmounts[arrNo] = cellAmount;
			       arrNo++;
		
		       }
	        }   
		    		   
		    var invoiceNo = JSON.stringify(arr);
		   document.getElementById('GravtyloadingUIHover').style.display = "block";
		     
    	 	var confirmationNo = document.getElementById('confNumber').value;    	 	   	   
           if($('#GravtymodalBodyCardSwipe').is(":visible")){
        	   
        	   //document.getElementById('loadingUIHoverOffers').style.display = "block";
 			  //document.getElementById('lblUIHoverOffers').innerHTML = "Fetching offers";
 			      
      	     var CardNo = document.getElementById('GravtytxtMemberCardNumberHidden').value;
     	 	//var VoucherCode =VoucherDetails.VoucherCode;
     	 	var VoucherCode = $("#VoucherPinGravty").val();
     	 	var amount = document.getElementById('txtGiftCardAmount').value;
     	 	var Memtype = $("#Memtype").val();     	  
                 $.ajax({
                     url: 'GravtyAvailPrivilageServlet',
                     cache: false,
                     type: "POST",
                     data: {          
                    	 InvoiceNo: invoiceNo,
                    	 Type:"CARD",
                    	 confirmationNo : confirmationNo,
                         CardNumber: CardNo   ,   
                         VoucherCode: VoucherCode,
                         Memtype:Memtype,
                         Amount: amount,
                         GlobalReservationNumber:'<%=request.getParameter("ReservId")%>',
                         GlobalPropertyCode: '<%=request.getParameter("Property")%>'
                     },
                     success : function(responseText) {
                     	//document.getElementById('DivLoading').style.display = "none";
                       //  window.location=responseText;
                      // alert(responseText);
               //   	   redirectToNewInovices(responseText);
               
                     	var resp = JSON.parse(responseText);
      	        	   
      	        	   var status = resp.status;
      	        	   var url = resp.url;
      	        	 var msg = resp.msg;
      	        	 if(status==="SUCCESS"){      
      	        		document.getElementById('GravtyloadingUIHover').style.display = "none";
      	        		//document.getElementById('GravtyloadingUIHover').style.display = "hidden";
      	        	//	setTimeout(function(){ alert("Sucessfully Availed. Navigating to Home Page"); }, 1000);        	        		
      	        		//setTimeout(function(){ redirectToNewInovices(url);  }, 6000);
      	        		$("#RedirectUrl").val(url);
      	        		document.getElementById('GravtymodalBodyCardSwipe').style.display = "none";
      	        		document.getElementById('GravtymodalUrlRedirect').style.display = "block";
      	        	   }      	        		  
      	        	   else
      	        		{
      	        		  $.alert(msg);
      	        		document.getElementById('GravtyloadingUIHover').style.display = "none";
           	        	// redirectToNewInovices(responseText);
      	        		}
                     },
                     error: function(errMsg){
                     	//document.getElementById('DivLoading').style.display = "none";
                     	//$.alert("An error occured: " + errMsg.status + " " + errMsg.statusText);
                     	alert("failed");
                     },
                     dataType: "text"
                 });
           }
           
           else if($('#GravtymodalBodyOTP').is(":visible")){
        	   
      	     var OTP = document.getElementById('GravtyOTP').value;
     	 	//var VoucherCode =VoucherDetails.VoucherCode;
     	 	var VoucherCode = $("#VoucherPinGravty").val();
     	 	var Memtype = $("#Memtype").val();     	    
                 $.ajax({
                     url: 'GravtyAvailPrivilageServlet',
                     cache: false,
                     type: "POST",
                     data: {     
                    	 Type:"OTP",
                    	 InvoiceNo: invoiceNo,
                    	 OTP: OTP   , 
                    	 confirmationNo : confirmationNo,
                         VoucherCode: VoucherCode,
                         Memtype:Memtype,
                         GlobalReservationNumber:'<%=request.getParameter("ReservId")%>',
                         GlobalPropertyCode: '<%=request.getParameter("Property")%>'
                     },
                     success : function(responseText) {
                     	//document.getElementById('DivLoading').style.display = "none";
                       //  window.location=responseText;
                //       alert(responseText);
                  	//   redirectToNewInovices(responseText);
                    		var resp = JSON.parse(responseText);
           	        	   
           	        	   var status = resp.status;
           	        	   var url = resp.url;
           	        	   var msg = resp.msg;
           	        	 if(status==="SUCCESS"){         
           	        		document.getElementById('GravtyloadingUIHover').style.display = "none";          	        		
          	        		//setTimeout(function(){ alert("Sucessfully Availed. Navigating to Home Page"); }, 1000);
          	        		$("#RedirectUrl").val(url);
          	        		document.getElementById('GravtymodalBodyOTP').style.display = "none";
          	        		document.getElementById('GravtymodalUrlRedirect').style.display = "block";
          	        	//	setTimeout(function(){ redirectToNewInovices(url);  }, 6000); 
           	        	   }      	        		  
           	        	   else
           	        		{
           	        		  $.alert(msg);
           	        		document.getElementById('GravtyloadingUIHover').style.display = "none";
                	        	// redirectToNewInovices(responseText);
           	        		}
                     },
                     error: function(errMsg){
                     	//document.getElementById('DivLoading').style.display = "none";
                     	//$.alert("An error occured: " + errMsg.status + " " + errMsg.statusText);
                     	$.alert("failed");
                     },
                     dataType: "text"
                 });
           }
           else if ($('#GravtymodalBodyPIN').is(":visible")){

      	     var InputPin = document.getElementById('txtPIN').value;
     	 	//var VoucherCode =VoucherDetails.VoucherCode;
     	 	var VoucherCode = $("#VoucherPinGravty").val();
     	 	var Memtype = $("#Memtype").val();
     	// 	alert(Memtype);    
                 $.ajax({
                     url: 'GravtyAvailPrivilageServlet',
                     cache: false,
                     type: "POST",
                     data: {            
                    	 Type:"PIN",
                    	 InvoiceNo: invoiceNo,
                    	 InputPin: InputPin, 
                    	 confirmationNo : confirmationNo,
                         VoucherCode: VoucherCode,
                         Memtype:Memtype,
                         GlobalReservationNumber:'<%=request.getParameter("ReservId")%>',
                         GlobalPropertyCode: '<%=request.getParameter("Property")%>'
                     },
                     success : function(responseText) {
                      	//document.getElementById('DivLoading').style.display = "none";
                        //  window.location=responseText;
                    //    alert(responseText);
                  // 	   redirectToNewInovices(responseText);
                    		var resp = JSON.parse(responseText);
           	        	   
           	        	   var status = resp.status;
           	        	   var url = resp.url;
           	        	var msg = resp.msg;
           	        	
           	        	 if(status==="SUCCESS"){        
           	        		document.getElementById('GravtyloadingUIHover').style.display = "none";          	        		
          	        	//	setTimeout(function(){ alert("Sucessfully Availed. Navigating to Home Page"); }, 1000);            	        		
          	        	//	setTimeout(function(){ redirectToNewInovices(url);  }, 6000);
           	        		$("#RedirectUrl").val(url);
          	        		document.getElementById('GravtymodalBodyPIN').style.display = "none";
          	        		document.getElementById('GravtymodalUrlRedirect').style.display = "block";
           	        	   }      	        		  
           	        	   else
           	        		{
           	        		  $.alert(msg);
           	        		document.getElementById('GravtyloadingUIHover').style.display = "none";
                	        	// redirectToNewInovices(responseText);
           	        		}
                      },
                     error: function(errMsg){
                     	//document.getElementById('DivLoading').style.display = "none";
                     	//$.alert("An error occured: " + errMsg.status + " " + errMsg.statusText);
                     	alert("failed");
                     },
                     dataType: "text"
                 });
           }

           
       }

   }

   
   
   //GravtycardSwiped() End
   
   //GravtygenerateOtp() - Start
   function GravtyUrlRedirect() {
	   var url= $("#RedirectUrl").val();
	   setTimeout(function(){ redirectToNewInovices(url);  }, 1000);   
	   
   }
   
 //GravtygenerateOtp() - End
   
   
   function payPointsGoBackBtn()
   {
       document.getElementById('modalBodyOTP').style.display = "none";
       document.getElementById('modalBodyCardSwipe').style.display = "none";
       document.getElementById('modalManualMemberNumberBody').style.display = "none";
       document.getElementById('modalBodyVerificationType').style.display = "block";
       document.getElementById('txtMemberCardNumberHidden').value = "";
       document.getElementById('txtOTP').value = "";
    //   document.getElementById('modalManualMemberNumberBody').style.display = "none";
       document.getElementById('txtOtpMemberNumber').value = "";
   }
   function TCPBackBtn()
   {
       document.getElementById('TCPmodalBodyOTP').style.display = "none";
       document.getElementById('TCPmodalOTP').style.display = "none";
       document.getElementById('TCPOTP').value = "";
   }
   
   function GravtypayPointsGoBackBtn()
   {
       document.getElementById('GravtymodalBodyOTP').style.display = "none";
       document.getElementById('GravtymodalBodyCardSwipe').style.display = "none";
       document.getElementById('GravtymodalBodyPIN').style.display = "none";
       document.getElementById('GravtymodalBodyVerificationType').style.display = "block";
       document.getElementById('txtMemberCardNumberHidden').value = "";
       document.getElementById('txtOTP').value = "";
       document.getElementById('GravtymodalManualMemberNumberBody').style.display = "none";
       document.getElementById('txtOtpMemberNumber').value = "";
   }
   
</script>


<!-- Script for sending OTP -->
<script type="text/javascript">
   function sendOTP(TcpCustomerHash)
   {
	   document.getElementById('lblUIHover').innerHTML = "Sending OTP...";
       document.getElementById('loadingUIHover').style.display = "block";
       document.getElementById('modalBodyOTP').style.display = "none";
       document.getElementById('modalManualMemberNumberBody').style.display = "none";
   	
       var PointsToRedeem = document.getElementById('txtTIC').value;
       
       $(document).ready(function() {
           $.ajax({
               url : 'SendOTPServlet',
               data: {
            	   TcpCustomerHash:TcpCustomerHash,
            	   PointsToRedeem:PointsToRedeem,
                   GlobalReservationNumber:'<%=request.getParameter("ReservId")%>',  	
                	   GlobalPropertyCode:'<%=request.getParameter("Property")%>'
                 },
               cache: false,
				success : function(responseText) {
            	   
                   document.getElementById('loadingUIHover').style.display = "none";
                   document.getElementById('modalBodyOTP').style.display = "block";
               	
                   var jsonObj = JSON.parse(responseText);
                   
                   if(jsonObj.status == "SUCCESS")
                   {
                     	                   	
                     	$.alert("OTP sent successfully");
     
                     } else{
                     	
                     	$.alert(jsonObj.msg);
     
                         //hide the current layout and display the verification layout
                         document.getElementById('modalBodyOTP').style.display = "none";
                         document.getElementById('modalBodyCardSwipe').style.display = "none";
                         document.getElementById('modalManualMemberNumberBody').style.display = "block";
     
                     	//showToast();
                     }
               },
               error: function (errMsg) {
                   //hide the loading layout
                   document.getElementById('loadingUIHover').style.display = "none";
                   //hide the current layout and display the verification layout
                   document.getElementById('modalBodyOTP').style.display = "none";
                   document.getElementById('modalBodyCardSwipe').style.display = "none";
                   document.getElementById('modalManualMemberNumberBody').style.display = "block";
   
               	//$.alert("An error occured: " + errMsg.status + " " + errMsg.statusText);
   
                   /* $("#lblOTPRes").empty();
                   $("#lblOTPRes").append("Failed to send OTP. \n Please try again later");
                   showToast(); */
                   $.alert("Failed to send OTP. \n Please try again later");
               },
               dataType: "text"
           });
       });
   }
   
   function showToast() {
       var x = document.getElementById("snackbar");
       x.className = "show";
       setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
   }
   
   function CheckGCBalance()
   {
	   
   	var CardNumber = document.getElementById('txtCardNo').value;
   	var CardPin = document.getElementById('txtCardPin').value;
   	var Type;
    var voucherNumber="";
    /* if(CardNumber.indexOf("EP-") > -1){
 	   MemberType="Epicure";
 	   voucherNumber=CardNumber;
 	   
    }	
    else if (CardNumber.indexOf("CH-") > -1){
 	   MemberType="Chambers";
 	   voucherNumber=CardNumber;	
    }           
    if(!voucherNumber==""){
    	Type="GRAVTY";
     }
    
    else{
    	Type="QGC";
    } */
    Type="QGC";
    	if(CardNumber == null || CardNumber == "")
       	{
       		$.alert("Enter Card Number to Proceed");
       		return;
       	} else
       	{
       	
        	document.getElementById('loadingUI').style.display = "block";
        	
        	$(document).ready(function() {
                $.ajax({
                    url : 'GiftCardBalanceEnquiry',
                    cache: false,
                    data: {
                    	Type:Type,
                    	CardNumber: CardNumber,
                    	CardPin: CardPin,
                    	GlobalReservationNumber:'<%=request.getParameter("ReservId")%>'
                    },
                    success : function(responseText) {
       
                    	document.getElementById('loadingUI').style.display = "none";
                    	
                    	$("#lblGCBalance").empty();
                        $("#lblGCBalance").append("&nbsp;&nbsp;&nbsp;"+responseText);
                        
                    },
                    error: function(errMsg){
                    	document.getElementById('DivLoading').style.display = "none";
                    	document.getElementById('loadingUI').style.display = "none";
                    	//$.alert("An error occured: " + errMsg.status + " " + errMsg.statusText);
                    },
                    dataType: "text"
                });
            });
       	} 	
    
      	
       
   }
   
</script>


<!-- Script for validating OTP and calling payUsingPoints -->
<script type="text/javascript">
   function validateOTP(InvoiceNo, Type, Amount, Points, PaymentType)
   {
   //code to validate the OTP 
          
          var UserOTP = document.getElementById('txtOTP').value;
   		  var MembershipNumber = document.getElementById('txtOtpMemberNumber').value;
          
          if(UserOTP == null || UserOTP == "")
          {
          	$.alert("Enter OTP to Proceed");
          	return;
          }
          
          //document.getElementById('modalBodyOTP').style.display = "none";
          //document.getElementById('lblUIHover').innerHTML = "Validating OTP...";
          //document.getElementById('loadingUIHover').style.display = "block";
          
          //call the payusingpoints directly
          payUsingPoint(InvoiceNo, Type, Amount, Points, PaymentType, MembershipNumber);
 
   }
   
      function payUsingPoint(InvoiceNo, Type, Amount, Points, PaymentType, MembershipNumber)
      {
    	  $('#modalOTP').modal('toggle');
          $("#DivLoading").load("loadingAnimation.html");
          
          var UserOTP = document.getElementById('txtOTP').value;
          var confirmationNumberDis = document.getElementById('labelConfirmationDisplay').value;
          var arrivalDis = document.getElementById('labelArrivalDisplay').value;
          var DepartureDis = document.getElementById('labelDepartureDisplay').value;
   
         // $.alert(InvoiceNo+ "\n" + Type + "\n" + Amount + "\n" + Points + "\n" + PaymentType);
   
          $(document).ready(function () {
              $.ajax({
                  url: 'ProcessInvoices',
                  cache: false,
                  type: "POST",
                  data: {
                      InvoiceNo: InvoiceNo,
                      Type: Type,
                      Amount: Amount,
                      Points: Points,
                      PaymentType: PaymentType,
                      MemberCardType:'OTP',
                      userEnteredOTP: UserOTP,
                      MembershipNumber: MembershipNumber,
                      confirmationNumberDis: confirmationNumberDis,
                      arrivalDis: arrivalDis,
                      DepartureDis: DepartureDis,
                      GlobalReservationNumber:'<%=request.getParameter("ReservId")%>',
                      GlobalPropertyCode:'<%=request.getParameter("Property")%>'                      
                  },
          		success : function(responseText) {
          			          		
          			window.location=responseText;
          			redirectToNewInovices(responseText);
          			
          			
          			
          			
          		},
                  dataType: "text"
              });
          });
      }
   
      
      
      
</script>

<!-- Invoices() -->
<script type="text/javascript">
   function Invoices() {
   
       var arrAmounts = [];
       var arr = [];
       var arrNo = 0;
       var chkbx = document.getElementsByName('checkbox');
       var totalAmountChecked = 0;
       
       
   
       for (a = 0; a < chkbx.length; a++) {
           var ifChk = chkbx[a].checked;
   
           if (ifChk) {
               var c = a + 1;
               var t = document.getElementById('myTable');
   
               var cell = t.rows.item(c).cells;
               var cellInv = cell.item(1).innerHTML;
               var cellAmount = cell.item(3).innerHTML;
   
               arr[arrNo] = cellInv;
               arrAmounts[arrNo] = cellAmount;
               arrNo++;
   
           }
       }
   
       for (var i = 0; i < arrAmounts.length; i++)
           totalAmountChecked = totalAmountChecked + parseFloat(arrAmounts[i]).toFixed(2);
   
       var payType = document.getElementsByName('rdoPayType');
       var payTypeVal;
       var payCount = 0;
       for (var i = 0; i < payType.length; i++) {
           if (payType[i].checked) {
               payTypeVal = payType[i].value;
               payCount++;
           }
       }
   
       /* var tempTotalAmount = document.getElementById('txtTotalAmount').value;
       
       if (tempTotalAmount === "" || tempTotalAmount === null || tempTotalAmount === "0" || tempTotalAmount === "0.00") {
           $.alert("Invalid amount entered");
           return;
       } */
       
       var totalAmount = parseFloat(document.getElementById('txtTotalAmount').value).toFixed(2);
       var TICPoints = document.getElementById('txtTIC').value;
       
   
       
       //$.alert(payTypeVal);
       //pay by TIC Points
       if (arr.length > 0) {
           if (payTypeVal == "tic" && payCount == 1) {
        	   
        	   var tempTotalAmount = totalAmount;
               
               if (tempTotalAmount === "" || tempTotalAmount === null || tempTotalAmount === "0" || tempTotalAmount === "0.00") {
                   $.alert("Invalid amount entered");
                   return;
               }
   
               var TICPointsAvailable = document.getElementById('txtTICPoints').value;
               
   
               if($('#modalOTP').is(":visible"))
               {
                   var jsonStr = JSON.stringify(arr);
                   
                   if($('#modalBodyCardSwipe').is(":visible")){
                	   cardSwipePayment(jsonStr, "TIC", totalAmount, TICPoints, "Points");
                   }
                   
                   else if($('#modalBodyOTP').is(":visible")){
                	   validateOTP(jsonStr, "TIC", totalAmount, TICPoints, "Points");
                   }
   
                   
               } else{
   
                   $('#modalOTP').modal({
                       backdrop: 'static',
                       keyboard: false,
                   });
   
               }
   
           } else if (payTypeVal == "card") {
   
               var CardNo = document.getElementById('txtCardNo').value;
               var CardPin = document.getElementById('txtCardPin').value;
               var CardAmount = document.getElementById('txtCardAmount').value;
   				
              // $.alert(CardAmount);
               
               if ((CardNo == null || CardNo == "") || (CardPin == null || CardPin == "")) {
                   $.alert("Card Details Required!");
                   return;
               } else if(CardAmount == null || CardAmount == "" || parseFloat(CardAmount) <= 0){
   
                   $.alert("Invalid Amount Entered");
                   return;
   
               } else if (parseFloat(CardAmount) > totalAmountChecked) {
                   $.alert("Invalid Amount Entered");
                   return;
               }
               else
               {
                 //  $("#DivLoading").load("loadingAnimation.html");
                  //document.getElementById('DivLoading').style.display = "block";  
                  //document.getElementById('GravtyGCloadingUIHover').style.display = "block";
      				document.getElementById('loadingUI').style.display = "block";
                   //GIftcard - pin availment Gravty block - Start
                   var MemberType;
                   var voucherNumber="";
                   /* if(CardNo.indexOf("EP-") > -1){
                	   MemberType="Epicure";
                	   voucherNumber=CardNo;
                	   
                   }	
                   else if (CardNo.indexOf("CH-") > -1){
                	   MemberType="Chambers";
                	   voucherNumber=CardNo;
                   } */           
                   if(!voucherNumber==""){
                	   var jsonStr = JSON.stringify(arr);
                            $.ajax({
                                url: 'ProcessInvoices',
                                cache: false,
                                type: "POST",
                                data: {                                           	 
                               	InvoiceNo: jsonStr,
                               	Memtype:MemberType,
                                Type: "GCPIN",
                                Amount: CardAmount,
                                CardNumber: CardNo,
                                CardPin: CardPin,
                                PaymentType: "GiftCard",
                                GCPayType: "Number",
                                GlobalReservationNumber:'<%=request.getParameter("ReservId")%>'
                                },
                                success : function(responseText_02) {
                                 	//document.getElementById('DivLoading').style.display = "none";
                                   //  window.location=responseText;
                               //    alert(responseText);
                             // 	   redirectToNewInovices(responseText);
                               //		var resp_str = JSON.stringify(responseText_02);
                               		var resp_ = JSON.parse(responseText_02);
                      	        	   var status_ = resp_.status;
                      	        	   var url_ = resp_.url;
                      	        	var msg_ = resp_.msg;
                      	        	
                      	        	 if(status_==="SUCCESS"){        
                      	        		document.getElementById('loadingUI').style.display = "none";   
                      	        		document.getElementById('GravtymodalBodyVerificationType').style.display = "none";
                     	        	//	setTimeout(function(){ alert("Sucessfully Availed. Navigating to Home Page"); }, 1000);
                     	      //  	alert("Sucessfully Availed. Navigating to Home Page");
                     	        	//	setTimeout(function(){ redirectToNewInovices(url_);  }, 6000);
                      	        		$("#RedirectUrl").val(url_);                     	        		
                     	        		$('#GravtymodalOTP').modal({
                 	                       backdrop: 'static',
                 	                       keyboard: false,
                 	                   });
                     	        		document.getElementById('GravtymodalUrlRedirect').style.display = "block";
                      	        	   }      	        		  
                      	        	   else
                      	        		{
                      	        		 document.getElementById('loadingUI').style.display = "none";                      	        		
                                        $.alert("" + msg_);                                      
                                      /*  $("#lblGCBalance").empty();
                        			$("#lblGCBalance").append("&nbsp;&nbsp;&nbsp;"+msg_);
                                       */   
                      	        		//  alert(msg_);
                      	        	//	document.getElementById('DivLoading').style.display = "none";
                           	        	// redirectToNewInovices(responseText);
                      	        		}
                      	        	
                                 },
                                error: function(errMsg){
                                	//document.getElementById('DivLoading').style.display = "none";
                                	//$.alert("An error occured: " + errMsg.status + " " + errMsg.statusText);
                                	 $("#lblGCBalance").empty();
                         			$("#lblGCBalance").append("&nbsp;&nbsp;&nbsp; Failed try again");
                                },
                                dataType: "text"
                            });
                   }
                          //GIftcard - pin availment Gravty block - End
                            
                   if(voucherNumber==""){
                   var jsonStr = JSON.stringify(arr);
   
                   $(document).ready(function () {
                       $.ajax({
                           url: 'ProcessInvoices',
                           cache: false,
                           type: "POST",
                           data: {
                               InvoiceNo: jsonStr,
                               Type: "QGC",
                               Amount: CardAmount,
                               CardNumber: CardNo,
                               CardPin: CardPin,
                               PaymentType: "GiftCard",
                               GCPayType: "Number",
                               GlobalReservationNumber:'<%=request.getParameter("ReservId")%>'
                           },
                           success : function(responseText) {
                        	 //  var resp_ = JSON.parse(responseText);              	        	
              	        	  // var url02 = resp_.url02;
              	        	
                           	document.getElementById('DivLoading').style.display = "none";
                            //   window.location=responseText;
                        	   redirectToNewInovices(responseText);
                           },
                           error: function(errMsg){
                        	   document.getElementById('DivLoading').style.display = "none";
                           	//$.alert("An error occured: " + errMsg.status + " " + errMsg.statusText);
                           },
                           dataType: "text"
                       });
                   });
               }
               }
   
           } else {
               $.alert("Select Payment Type to Proceed");
               return;
           }
       } else {
           $.alert("Select Invoice to Proceed");
           return;
       }
   
   }
</script>


<!-- Script for Select all the invoices at once -->
<script type="text/javascript">
   function selectAll() {
       var chkSel = document.getElementById('checkSelect').checked;
   
       var chkbx = document.getElementsByName('checkbox');
   
       if (chkSel) {
           for (a = 0; a < chkbx.length; a++)
               chkbx[a].checked = true;
       } else {
           for (a = 0; a < chkbx.length; a++)
               chkbx[a].checked = false;
       }
   
       CalculateAmount();
   }
</script>


<!-- Script for unchecking the SelectAll checkbox -->
<script type="text/javascript">
   function validateAll() {
   
       //validating the checl all
       var chkSel = document.getElementById('checkSelect');
       if (chkSel)
           chkSel.checked = false;
   
       CalculateAmount();
   
   }
</script>


<!-- Script for Calculating the Amount based on Specific Selection -->
<script type="text/javascript">
   function CalculateAmount() {
   
       //calculating the points based on selected invoices total amount
       var chkbx = document.getElementsByName('checkbox');
   
       var arrAmounts = [];
       var arrNos = 0;
       var totalAmount = 0;
       var TICPointPerAmount = 1;
       var totalPointsTIC = 0;
      
   
       for (a = 0; a < chkbx.length; a++) {
           var ifChk = chkbx[a].checked;
   
           if (ifChk) {
               var c = a + 1;
               var t = document.getElementById('myTable');
   				
               var cell = t.rows.item(c).cells;
               var cellVal = parseFloat(cell.item(3).innerHTML);
              // $.alert(cellVal);
               arrAmounts[arrNos] = cellVal;
               arrNos++;
   
           }
       }
       var Reservation_Status = $("#Reservation_Status").val();       
       var Reservation_Status_ =$("#Reservation_status_").val();
       if(Reservation_Status_ =="CANCELLED" ||  Reservation_Status_ =="NO SHOW"  ||  Reservation_Status_ =="CHECKED OUT"  )
	   {
	   $.alert("Option is not available for this Reservation")
	   return;
	   }
       else if(Reservation_Status_ !="CHECKED IN")// && Reservation_Status_ !="Not Guarantee"
    	   {
    	   $.alert("Please CheckIn to use points")
    	   return;
    	   }      
     
       
       if(parseInt(arrNos) <= 0)
       {
    	   $.alert("Please choose the window to proceed with the points redemption");
       }
   
       for (var i = 0; i < arrAmounts.length; i++)
		{
			totalAmount = +totalAmount + arrAmounts[i];
    	}
   
       //$.alert(totalAmount);
    var type;
       var payType = document.querySelector('input[name="rdoType"]:checked').value;
       if (payType === 'point') {
           //type = document.querySelector('input[name="rdoPayType"]:checked').value;
    	   type = "tic";
       } else if (payType === 'card')
       {
           type = document.querySelector('input[name="rdoPayType"]:checked').value;
       }
   
       //code for currency converter
       $(document).ready(function () {
           $.ajax({
               url: 'GetCurrencyRate',
               cache: false,
               type: "POST",
               data: {
                   GlobalReservationNumber:'<%=request.getParameter("ReservId")%>'
               },
               success : function(responseText) {

            	   //total*responseText
            	   //this is converted INR rupees value
            	   var convertedAmount = totalAmount * parseFloat(responseText);
            	   
            	   totalPointsTIC = convertedAmount / TICPointPerAmount;
            	   document.getElementById('RateEx').value = responseText;
               
                   if (type === "tic")
                   {
                       document.getElementById('divPayCard').style.display = "none";
                       document.getElementById('divPayPoint').style.display = "block";
                       document.getElementById('divGiftCardSwipe').style.display = "none";

                       document.getElementById('txtGiftCardAmount').value = "";
                       document.getElementById('txtCardAmount').value = "";
               
                       document.getElementById('txtTotalAmount').value = totalAmount.toFixed(2);
                       document.getElementById('txtTIC').value = Math.ceil(totalPointsTIC);
                       document.getElementById('txtTIC').disabled = false;
                       
                   } else if (type === "cardSwipe" || type === "card")
                   {
                       if (type === "cardSwipe")
                       {
                           document.getElementById('divPayCard').style.display = "none";
                           document.getElementById('divPayPoint').style.display = "none";

                           document.getElementById('txtCardAmount').value = "";

                           document.getElementById('txtTIC').disabled = true;
                           document.getElementById('txtTIC').value = "";

                           document.getElementById('txtGiftCardAmount').value = totalAmount.toFixed(2);
                           document.getElementById('divGiftCardSwipe').style.display = "block";
                        

                       } else if (type === "card")
                       {
                           document.getElementById('divPayCard').style.display = "block";
                           document.getElementById('divPayPoint').style.display = "none";
                           document.getElementById('divGiftCardSwipe').style.display = "none";

                           document.getElementById('txtCardAmount').value = totalAmount.toFixed(2);
                           document.getElementById('txtGiftCardAmount').value = "";
                           document.getElementById('txtTIC').disabled = true;
                           document.getElementById('txtTIC').value = "";
                       }
                   }
               
                   
            	   
               },
               error: function(errMsg){
               	document.getElementById('DivLoading').style.display = "none";
               	//$.alert("An error occured: " + errMsg.status + " " + errMsg.statusText);
               },
               dataType: "text"
           });
       });
       
       
   
   }
</script>


<!-- Script for Calculating the Amount and converting when changing the value of Point's textbox's-->
<script type="text/javascript">

   function changeTIC() {
       //calculating the points based on selected invoices total amount
       var chkbx = document.getElementsByName('checkbox');
   
       var arrAmounts = [];
       var arrNos = 0;
       var totalAmount = 0;
       var TICPointPerAmount = 1;
       var totalPointsTIC = 0;
      
       for (a = 0; a < chkbx.length; a++) {
           var ifChk = chkbx[a].checked;
   
           if (ifChk) {
               var c = a + 1;
               var t = document.getElementById('myTable');
   
               var cell = t.rows.item(c).cells;
               var cellVal = cell.item(3).innerHTML;
   
               arrAmounts[arrNos] = cellVal;
               arrNos++;
   
           }
       }
   
       for (var i = 0; i < arrAmounts.length; i++)
           totalAmount = +totalAmount + +arrAmounts[i];
   
       	
       var Reservation_Status =$("#Reservation_Status").val();
       
       if(Reservation_Status =="CANCELLED" ||  Reservation_Status =="NO SHOW"  ||  Reservation_Status =="CHECKED OUT"  )
	   {
	   $.alert("Option is not available for this Reservation")
	   return;
	   }
       if(Reservation_Status !="CHECKED IN")// && Reservation_Status !="Not Guarantee"
	   {
	   $.alert("Please CheckIn to use points")
	   return;
	   }
       
       if (arrAmounts.length <= 0) 
   	{
   	   $.alert("Please select invoice to proceed")
   	   return;
   	}
              
       var TIC = document.getElementById('txtTIC').value;
       var TICPointsAvailable = document.getElementById('txtTICPoints').value;
       var total = document.getElementById('txtTotalAmount');
   
       var totAmount = TICPointPerAmount * TIC;
       
       //code for currency converter
       $(document).ready(function () {
           $.ajax({
               url: 'GetCurrencyRate',
               cache: false,
               type: "POST",
               data: {
                   GlobalReservationNumber:'<%=request.getParameter("ReservId")%>'
               },
               success : function(responseText) {

            	   //totAmount/conversionRate
            	   
            	   var convertedAmount = totAmount/parseFloat(responseText);
            	   
            	   console.log("convertedAmount: " + convertedAmount + "\n totalAmount: " + totalAmount );
                      
            	   if (convertedAmount == "NaN" || convertedAmount === "NaN"){
   					$.alert("Please enter valid amount");
   				    total.value = '0';
   				    TIC.value = '0';
   				    return;
   					}
   				   if (convertedAmount > totalAmount) {
         	           $.alert("Please enter a lesser amount");
         	           total.value = '0';
         	           TIC.value = '0';
         	           
         	           return;
         	       } else
         	           total.value = (Math.round(convertedAmount)).toFixed(2);
               },
               error: function(errMsg){
               	document.getElementById('DivLoading').style.display = "none";
               	//$.alert("An error occured: " + errMsg.status + " " + errMsg.statusText);
               },
               dataType: "text"
           });
       });
   
       
   }
   
   function changeTotal() {
       //calculating the points based on selected invoices total amount
       var chkbx = document.getElementsByName('checkbox');
   
       var arrAmounts = [];
       var arrNos = 0;
       var totalAmount = 0;
       var TICPointPerAmount = 1;
       var totalPointsTIC = 0;
       
       for (a = 0; a < chkbx.length; a++) {
           var ifChk = chkbx[a].checked;
   
           if (ifChk) {
               var c = a + 1;
               var t = document.getElementById('myTable');
   
               var cell = t.rows.item(c).cells;
               var cellVal = cell.item(3).innerHTML;
   
               arrAmounts[arrNos] = cellVal;
               arrNos++;
   
           }
       }
   
       for (var i = 0; i < arrAmounts.length; i++)
           totalAmount = +totalAmount + +arrAmounts[i];
   
       if (arrAmounts.length <= 0) 
	   	{
	   	   $.alert("Please select invoice to proceed")
	   	   return;
	   	}
   
       var tempTotal = document.getElementById('txtTotalAmount').value;
       
       if(tempTotal == "" || tempTotal == null || tempTotal == "null")
       {
    	   $.alert("Invalid amount entered");
    	   return;
       }
       
       var total = parseFloat(document.getElementById('txtTotalAmount').value).toFixed(2);
   
       //console.log("Total: " + total + "\n Total Amount: " + totalAmount );
       
       
       
       if (total > totalAmount) {
           $.alert("Please enter a lesser amount");
           total.value = '0';
           return;
       }
   		
       //code for currency converter
       $(document).ready(function () {
           $.ajax({
               url: 'GetCurrencyRate',
               cache: false,
               type: "POST",
               data: {
                   GlobalReservationNumber:'<%=request.getParameter("ReservId")%>'
               },
               success : function(responseText) {

            	   //total*responseText
            	   var convertedAmount = total * parseFloat(responseText);
            	   
            	   totalPointsTIC = convertedAmount / TICPointPerAmount;
                   
                   var type = document.querySelector('input[name="rdoPayType"]:checked').value;
               
                   if (type == "tic") {
                       document.getElementById('txtTIC').value = Math.ceil(totalPointsTIC);
                       document.getElementById('txtTIC').disabled = false;
                   } else if (type == "card") {
                       document.getElementById('txtTIC').disabled = true;
                       document.getElementById('txtTIC').value = "";
                   }
            	   
               },
               error: function(errMsg){
               	document.getElementById('DivLoading').style.display = "none";
               	//$.alert("An error occured: " + errMsg.status + " " + errMsg.statusText);
               },
               dataType: "text"
           });
       });
       
       
   }
   
</script>

<!-- <script>
    var html = '';
    $(document).ready(function(){
        $('tr').click(function () {
            $(this).find('input:checkbox').prop('checked', 'checked');
            
        });
    });

</script>
 -->
 
<script>
  $( function() {
    $( "#dialog" ).dialog();
  } );
</script>
 
 
 <!-- Script for new changes Start -->

    <script type="text/javascript">
        function divFirstStep()
        {
        	
            	var type = document.querySelector('input[name="rdoType"]:checked').value;

                document.getElementById('divFirstStep').style.display = "none";

                if (type === "point")
                {
                    //document.getElementById('divTwoPointOne').style.display = "block";
                    $("#rdoTIC").prop("checked", true);
                    CalculateAmount();
                } else if(type === "card")
                {
                    document.getElementById('divOnePointTwo').style.display = "block";
                    $("#rdoTIC").prop("checked", false);
                }
            
        	
            

        }

        function btnGoToDivFirstStep()
        {
            document.getElementById('divTwoPointOne').style.display = "none";
            document.getElementById('divOnePointTwo').style.display = "none";
            
            document.getElementById('divPayPoint').style.display = "none";
            document.getElementById('divPayCard').style.display = "none";
            document.getElementById('divGiftCardSwipe').style.display = "none";
            
            //document.getElementById('divPayCard').style.display = "none";
            $('input[name=rdoType]').prop('checked', false);
            $('input[name=rdoPayType]').prop('checked', false);
            document.getElementById('divFirstStep').style.display = "block";
            
            document.getElementById('txtTotalAmount').value = "";
            document.getElementById('txtTIC').value = "";
            document.getElementById('txtCardNo').value = "";
            document.getElementById('txtCardPin').value = "";
            document.getElementById('txtCardAmount').value = "";
            document.getElementById('txtGiftCardAmount').value = "";
            
        }

        function divOnePointOne()
        {
            var type = document.querySelector('input[name="rdoMemberCardType"]:checked').value;

            document.getElementById('divOnePointOne').style.display = "none";

            if (type === "selfTIC" || type === "otherTIC")
            {
            	if (type === "selfTIC") {
                    document.getElementById('btnEnableOTPModal').style.display = "inline";
                } else if (type === "otherTIC")
                {
                    document.getElementById('btnEnableOTPModal').style.display = "none";
                }
                document.getElementById('divTwoPointOne').style.display = "block";
            }
        }

        function btnGoTodivOnePointOne()
        {
            document.getElementById('divTwoPointOne').style.display = "none";
            document.getElementById('divPayPoint').style.display = "none";
            $('input[name=rdoMemberCardType]').prop('checked', false);
            $('input[name=rdoPayType]').prop('checked', false);
            document.getElementById('divOnePointOne').style.display = "block";

        }

        function btnGoToDivTwoPointOne()
        {

        }
    </script>

<!-- Script for new changes End -->
 
 <script>
 	function redirectToNewInovices(responseUrl){
 		var getParams = function (url) {
 			var params = {};
 			var parser = document.createElement('a');
 			parser.href = url;
 			var query = parser.search.substring(1);
 			var vars = query.split('&');
 			for (var i = 0; i < vars.length; i++) {
 				var pair = vars[i].split('=');
 				params[pair[0]] = decodeURIComponent(pair[1]);
 			}
 			return params;
 		};

 		var params = getParams(responseUrl);
 	 	var Url =  responseUrl.substr(0, responseUrl.indexOf('?')); 	 		 
		$(document).ready(function(){
			$('<form action="'+Url+'" method="POST">'+
		    	'<input type="hidden" name="ReservId" value="'+params.ReservId+'">'+
	    		'<input type="hidden" name="Property" value="'+params.Property+'">'+
	    		'<input type="hidden" name="PayStatus" value="'+params.PayStatus+'">'+
			    '</form>').appendTo('body').submit();
		});
 	 	
	}
 	
 </script>
 
<style type="text/css">
fieldset {
	margin-left: 2px;
	margin-right: 2px;
	padding-top: 0.35em;
	padding-bottom: 0.625em;
	padding-left: 0.75em;
	padding-right: 0.75em;
	border: 2px groove(internal value);
}

a {
	color: blue;
}

.menucustom {
	/*margin-right: 30px;*/
	height: 100%;
	padding-top: 5px;
	padding-left: 8px;
	padding-right: 8px;
	font-family: serif;
	/*border-radius: 4px;*/
	font-weight: normal;
	/* margin-top: 3px; */
}

/* Add a black background color to the top navigation */
.topnav {
	/*margin: 0px;*/
	/* padding-top:10px;
		padding-bottom: 10px; */
	/*height: 40px;*/
	background-color: #B2DFDB;
	/*overflow: hidden;*/
}

.topnavBar {
	margin: 0px;
	/* padding-top:10px;
		padding-bottom: 10px; */
	height: 20px;
	background-color: #dee8e7;
	overflow: hidden;
}

/* Style the links inside the navigation bar */
.topnav a {
	float: left;
	color: black;
	text-align: center;
	text-decoration: blink;
	font-size: 17px;
	font-family: serif;
}

/* Change the color of links on hover */
.topnav a:hover {
	background-color: #00796B;
	color: white;
}

.topnav a.active {
	background-color: #009688;
	color: black;
}
</style>



<style>
    .tableStyle {
        font-size: 0.95vw;
        margin-left: 20px;
    }

    .splitLeft {
        height:100%;
        width: 64%;
        float: left;
        display: inline-block;
        left: 0;
    }

    .splitRight {
        height:100%;
        width: 34%;
        float: right;
        display: inline-block;
        right: 0;
        
    }

  
</style>

<style>
#snackbar {
    visibility: hidden;
    min-width: 250px;
    margin-left: -125px;
    background-color: #333;
    color: #fff;
    text-align: center;
    border-radius: 2px;
    padding: 16px;
    position: fixed;
    z-index: 1;
    left: 40%;
    bottom: 50%;
    font-size: 17px;
}

#snackbar.show {
    visibility: visible;
    -webkit-animation: fadein 0.5s, fadeout 0.5s 2.5s;
    animation: fadein 0.5s, fadeout 0.5s 2.5s;
}

@-webkit-keyframes fadein {
    from {bottom: 0; opacity: 0;} 
    to {bottom: 50%; opacity: 1;}
}

@keyframes fadein {
    from {bottom: 0; opacity: 0;}
    to {bottom: 50%; opacity: 1;}
}

@-webkit-keyframes fadeout {
    from {bottom: 50%; opacity: 1;} 
    to {bottom: 0; opacity: 0;}
}

@keyframes fadeout {
    from {bottom: 50%; opacity: 1;}
    to {bottom: 0; opacity: 0;}
}
</style>

<style type="text/css">
	
	.loadingUI {
	  position: fixed;
	  top: 40%;
	  left: 50%;
	  margin-top: -50px;
	  margin-left: -100px;
}

.loadingUIHover {
	  position: fixed;
	  top: 12%;
	  left: 37%;
	  margin-top: -50px;
	  margin-left: -100px;
}

.loader {
  border: 16px solid #f3f3f3;
  border-radius: 50%;
  border-top: 16px solid #3498db;
  width: 80px;
  height: 80px;
  -webkit-animation: spin 2s linear infinite; /* Safari */
  animation: spin 2s linear infinite;
}

/* Safari */
@-webkit-keyframes spin {
  0% { -webkit-transform: rotate(0deg); }
  100% { -webkit-transform: rotate(360deg); }
}

@keyframes spin {
  0% { transform: rotate(0deg); }
  100% { transform: rotate(360deg); }
}
	
</style>

<!-- Style Code for removing the focus blur glow from textbox -->
<style type="text/css">
     textarea:focus, input[type="text"]:focus, input[type="password"]:focus, input[type="datetime"]:focus, input[type="datetime-local"]:focus, input[type="date"]:focus, input[type="month"]:focus, input[type="time"]:focus, input[type="week"]:focus, input[type="number"]:focus, input[type="email"]:focus, input[type="url"]:focus, input[type="search"]:focus, input[type="tel"]:focus, input[type="color"]:focus, .uneditable-input:focus 
     {   
         border-color: none;
         box-shadow: 0 0 0 0;
         outline: 0 none;
     }
 </style>

</head>
<body style="background: #DFDBDA; height: 100%" ng-app="myApp" ng-controller="myCtrl" >

<%


 try
 {	 
	 String ResId = request.getParameter("ReservId");
	 String URLPropertyCode = request.getParameter("Property");
	 if(ResId == null || ResId.trim().equalsIgnoreCase("") || URLPropertyCode == null || URLPropertyCode.trim().equalsIgnoreCase(""))
	 {
		 %>
			<script type="text/javascript">
				window.location="NoReservation.jsp";
			</script>
		<%
		 //servletResponse.sendRedirect("NoReservation.jsp");
		return;
	 }
	 
	 
	 
	 NewInvoicesData newInvoicesData = new NewInvoicesData();
	/*  */
	 ProcessInvoicesData processInvoicesData = new ProcessInvoicesData();
	 
	 processInvoicesData.URLPropertyCode = URLPropertyCode;	 
	 
	 HashMapData.mapProcessInvoices.put(request.getParameter("ReservId"), processInvoicesData);
	 /*  */
	 HashMapData.mapNewInvoices.put(request.getParameter("ReservId"), newInvoicesData);
	 newInvoicesData = HashMapData.mapNewInvoices.get(request.getParameter("ReservId"));
	 
	 StoreInvoiceDetails storeInvoiceDetails = new StoreInvoiceDetails();
	 
	 storeInvoiceDetails.ReservationID = ResId;
	 
	 newInvoicesData.URLPropertyCode = URLPropertyCode;
	 
	 HashMapData.mapInvoiceData.put(request.getParameter("ReservId"), storeInvoiceDetails);
	 HashMapData.mapNewInvoices.put(request.getParameter("ReservId"), newInvoicesData);
	 
 }catch(Exception e)
 {
	 e.printStackTrace();
	 %>
    	<script type="text/javascript">
    		window.location="NoReservation.jsp";
    	</script>
    <%
	// response.sendRedirect("NoReservation.jsp");
	
	 return;
 }

try{
	
	String PayStatus = request.getParameter("PayStatus");
	
	if(PayStatus.equals("success"))
	{
		%>
			<script>
                  var header = "<h4><b>Availment Success</b></h4>";
                  var msg = "<h4>Availment done Successfuly</h4>";
                  $.alert(header+msg);
			</script>
		<%
	} 
	 
		else if(request.getParameter("PayStatus").equals("successButNotWrittenBacktoPMS")){
			%>
			<script>
	              var header = "<h4><b>Pre Checked In - Availment Success</b></h4>";
	              var msg = "<h4> Pre Checked In Availment done Successfully </h4>";
	              $.alert(header+msg);
			</script>
		<%
		}
	else if(request.getParameter("PayStatus").equals("failedSiebelError"))
	{
		%>
			<script>
                  //var header = "<h4><b>Transaction Failed</b></h4>";
                  //var msg = "<h4>Unable to get the property code</h4>";
                  var msg = "Request could not be fulfiled at the moment <br/>please try again in few seconds"
                  $.alert(msg);
			</script>
		<%
	} else if(request.getParameter("PayStatus").equals("failedSiebelProperty"))
	{
		%>
			<script>
                  var header = "<h4><b>Transaction Failed</b></h4>";
                  var msg = "<h4>Unable to get the property code</h4>";
                  $.alert(header+msg);
			</script>
		<%
	}else if(request.getParameter("PayStatus").equals("failedSiebel"))
	{
		%>
			<script>
                  var header = "<h4><b>Transaction Failed</b></h4><br/>";
                  var msg = "<h4>Failed to reedem points</h4>";
                  var msg1 = "<h4>Please contact administration</h4>";
                  $.alert(header+msg+msg1);
			</script>	
		<%
	}else if(PayStatus.equals("failedBatch"))
	{
		%>
			<script>
                  var header = "<h4><b>Transaction Failed</b></h4>";
                  var msg = "<h4>Unable to Generate the GiftCard Batch Number</h4> <br/>";
                  var msg1 = "<h4>Please try again later</h4>";
                  $.alert(header+msg+msg1);
			</script>			
		<%
	}else if(PayStatus.equals("failedGC"))
	{
		GiftCardData giftCardData = HashMapData.mapGiftCard.get(request.getParameter("ReservId"));
		String GCErrMsg = "";
		try{
			GCErrMsg = giftCardData.errorMsg;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		giftCardData.errorMsg = "";
		HashMapData.mapGiftCard.put(request.getParameter("ReservId"), giftCardData);
		
		%>
			<script>
                  var header = "<h4><b>Transaction Failed</b></h4>";
                  var msg = "<h4>Payment failed using GiftCard</h4> <br/> <b>Info:</b> <br/>";
                  var msg1 = '<%=GCErrMsg %>';
                  $.alert(header+msg+"<h4>"+msg1+"</h4><br/>");
			</script>					
			
		<%
	} else if(PayStatus.equals("failedPMS"))
	{
		%>
			<script>
                  var header = "<h4><b>Transaction Failed</b></h4>";
                  var msg = "<h4>Payment Successful, but failed while posting transaction information to PMS</h4> <br/>";
                  $.alert(header+msg);
			</script>	
		<%
	} 
	else if(PayStatus.equals("availmentFailed"))
	{
		%>
			<script>
                  var header = "<h4><b>Availment Failed</b></h4>";
                  var msg = "<h4>The Availment failed. Navigating to home page</h4> <br/>";
                  $.alert(header+msg);
			</script>	
		<%
	} 
	else if(PayStatus.equals("failedSiebelOTP"))
	{
		%>
			<script>
                  var header = "<h4><b>Availment Failed</b></h4>";
                  var msg = "<h4>The Availment failed due to invalid OTP. Navigating to home page</h4> <br/>";
                  $.alert(header+msg);
			</script>	
		<%
	} 
	
}catch(Exception e)
{
	e.getMessage();
}
 
 	//String ResId = "16653";
 				
 				//Get the Reservation Data and Validate the reservation 'STATUS'
 				
 				//GetReservationData reservationData = new GetReservationData(request.getParameter("ReservId"), request.getParameter("Property"));
        	/* 	
 				GetReservationData reservationData = new GetReservationData(
    request.getParameter("ReservId"), 
    request.getParameter("Property"),
    request.getParameter("status") );
 				Thread threadReservation = new Thread(reservationData);
        		threadReservation.start();
        		threadReservation.join(); */
        		String reservId = request.getParameter("ReservId");
 				String property = request.getParameter("Property");
 				String flagParam = request.getParameter("flag");
 				if(flagParam == null || flagParam.trim().equals("")) {
 					flagParam = "P";   // Default flag for production
 				}

 				System.out.println("DEBUG JSP: ReservId = " + reservId);
 				System.out.println("DEBUG JSP: Property = " + property);
 				System.out.println("DEBUG JSP: flag = " + flagParam);
 				System.out.println("DEBUG JSP: All parameters: " + request.getQueryString());

 				GetReservationData reservationData = new GetReservationData(reservId, property, flagParam);
        		Thread threadReservation = new Thread(reservationData);
        		threadReservation.start();
        		threadReservation.join();
        		
        		HashMapData.mapReservationData.put(request.getParameter("ReservId"), reservationData);
        		
        		GetReservationData getReservationData = HashMapData.mapReservationData.get(request.getParameter("ReservId"));
        		
        		NewInvoicesData newInvoicesData = new NewInvoicesData();

        		HashMapData.mapNewInvoices.put(request.getParameter("ReservId"), newInvoicesData);
        		newInvoicesData = HashMapData.mapNewInvoices.get(request.getParameter("ReservId"));
        		
        		newInvoicesData.PropertyCode = getReservationData.HotelCode;
        		newInvoicesData.ReservationStatus = getReservationData.Status;
        		
        		HashMapData.mapNewInvoices.put(request.getParameter("ReservId"), newInvoicesData);
        		newInvoicesData = HashMapData.mapNewInvoices.get(request.getParameter("ReservId"));
        		
        		if(newInvoicesData.ReservationStatus.equalsIgnoreCase("error"))
        		{
        			%>
    					<script type="text/javascript">
    						window.location="ReservationError.jsp";
    					</script>
    				<%
        			
        			//response.sendRedirect("NoReservation.jsp");
        			return;
        		} 
 				
        		newInvoicesData.invoiceResponse = "";
        		
            	newInvoicesData.invoiceResponse = reservationData.resp;
            	HashMapData.mapNewInvoices.put(request.getParameter("ReservId"), newInvoicesData);
            	newInvoicesData = HashMapData.mapNewInvoices.get(request.getParameter("ReservId"));
            	
            	System.out.println("Response FetchInvoice: " + newInvoicesData.invoiceResponse);
            	if(newInvoicesData.invoiceResponse.contains("Error 503--Service Unavailable")  || newInvoicesData.invoiceResponse.contains("Service Unavailable") || newInvoicesData.invoiceResponse.contains("Error 503")  || newInvoicesData.invoiceResponse.contains("Error 503--Service Unavailable")){
    				System.out.println("503 Server Unavalable fetch invoice");
    				%>
    					<script type="text/javascript">
    						window.location="ServerUnavailableFI.jsp";
    					</script>
    				<%
    				return;
    			}
            	 
        		
        		if (false)
        		{
        			newInvoicesData.soapExecutor = new SoapExecutor();
                	Document  doc1= newInvoicesData.soapExecutor.convertStringToDocument(newInvoicesData.invoiceResponse);
                	//System.out.println("Response TXT: " + invoiceResponse);
            		newInvoicesData.nList = doc1.getElementsByTagName("s0:Invoice");
            		newInvoicesData.Ele = (Element) (Node) newInvoicesData.nList.item(0);
            		
            		HashMapData.mapNewInvoices.put(request.getParameter("ReservId"), newInvoicesData);
            		newInvoicesData = HashMapData.mapNewInvoices.get(request.getParameter("ReservId"));
        			Element eleSuccess = (Element) doc1.getElementsByTagName("s0:Result").item(0);
        			
        			String status = eleSuccess.getAttribute("resultStatusFlag");
        			
        			if(status.equals("SUCCESS"))
        			{
        				Element ele1 = (Element) eleSuccess.getElementsByTagName("s2:Text").item(0);
        				
        				Element ele2 = (Element) ele1.getElementsByTagName("s2:TextElement").item(0);
        				
        				String msg = ele2.getTextContent();
        				
        				if(msg.contains("No Folio Records Found"))
        				{
        				
							//redirect to NoFolioFound page
						
	        			//return;
        				}
        				
        			}
        			else
        			{
	        			%>
							<script type="text/javascript">
								window.location="ReservationError.jsp";
							</script>
						<%
	        			return;
        			}
        			
        		}
        		
        		//PMS Profile ID
        		//NodeList nListPMS = newInvoicesData.Ele.getElementsByTagName("s5:ProfileIDs");
        		//Element elePMS = (Element) nListPMS.item(0);
        		
        		//newInvoicesData.PMSId = newInvoicesData.soapExecutor.getValue(elePMS, "s2:UniqueID");
        		
        		newInvoicesData.PMSId = reservationData.PMSNameCode;
        		
        		HashMapData.mapNewInvoices.put(request.getParameter("ReservId"), newInvoicesData);
        		newInvoicesData = HashMapData.mapNewInvoices.get(request.getParameter("ReservId"));
        		
        		System.out.println("PMS ID: " + newInvoicesData.PMSId);
        		
        		        		
        		/* ============================================================== */
        		
        			
        		//Call the function to fetch the profile data
        		
        			System.out.println("PMS Profile:\t" + newInvoicesData.PMSId);
        			if(getReservationData.ErrorFlag503.equals("503ERROR")){
	        			System.out.println("503 Server Unavalable");
        				%>
	    					<script type="text/javascript">
	    						window.location="ServerUnavailableFBS.jsp";
	    					</script>
	    				<%
	    				return;
	        			
	        		}        		 
	        		GetProfileData profileData = new GetProfileData(newInvoicesData.PMSId, request.getParameter("ReservId"), request.getParameter("Property"),request, response);
	        		Thread thread = new Thread(profileData);
	        		thread.start();
	        		thread.join();
	        		
	        		
	        		if(!profileData.isProfileFound)
	        		{
	        			System.out.println("Profile Not Found");
        				%>
	    					<script type="text/javascript">
	    						window.location="NoProfileMDM.jsp";
	    					</script>
	    				<%
            			return;
	        		}
	        		else if(getReservationData.ReservationMDM.equals("NOT FOUND IN MDM"))
	        		{
	        			System.out.println("Reservation Not Found in MDM");
        				%>
	    					<script type="text/javascript">
	    						window.location="NoReservationMDM.jsp";
	    					</script>
	    				<%
            			return;
	        		}
	        		
	        		HashMapData.mapProfileData.put(request.getParameter("ReservId"), profileData);
	        		
	        		GetProfileData getProfileData = HashMapData.mapProfileData.get(request.getParameter("ReservId"));
	        		
	        		newInvoicesData.MDMProfileID = getProfileData.PartyId;
	        		newInvoicesData.MDMPartyNumber = getProfileData.PartyNumber;
	        		newInvoicesData.FirstName = getProfileData.FirstName;
	        		newInvoicesData.LastName = getProfileData.LastName;
	        		newInvoicesData.AddressLine = getProfileData.Address1 + " " + getProfileData.Address2 + " " + getProfileData.Address3 + " " + getProfileData.Address4 + "";
	        		newInvoicesData.CountryCode = getProfileData.country;
	        		String status = GetReservationData.Reservation_status;
	        		newInvoicesData.Reservation_status =status;	        			
	        		HashMapData.mapMemberData.put(request.getParameter("ReservId"), new GetMemberData());
	        		
	        		if(getProfileData.membershipNumber != null && !getProfileData.membershipNumber.equalsIgnoreCase(""))
	        		{
	        		//	newInvoicesData.MembershipNumber = getProfileData.EnrollNumber_c;
	        			newInvoicesData.MembershipNumberTPM = getProfileData.TPMMemberNumber;
	        			newInvoicesData.MembershipNumberTIC = getProfileData.TICMemberNumber;
	        			//handle non tic memberships
	        			if(getProfileData.TICMemberNumber.equals("") && (!getProfileData.TPMMemberNumber.equals(""))){//(!getProfileData.TPMMemberNumber.equals(""))){
	        				newInvoicesData.MembershipNumberTIC = getProfileData.TPMMemberNumber;//getProfileData.TPMMemberNumber;
	        				System.out.println(newInvoicesData.MembershipNumberTIC);
	        			}else if(!(getProfileData.TICMemberNumber.equals("")) && getProfileData.TPMMemberNumber.equals(""))//&& getProfileData.TPMMemberNumber.equals(""))
	        			{
	        				newInvoicesData.MembershipNumberTIC = getProfileData.TICMemberNumber;
	        			}
	        					
	        					
	        			newInvoicesData.MembershipNumberCH = getProfileData.CHMemberNumber;
	        			newInvoicesData.MembershipNumberEPI = getProfileData.EPIMemberNumber;
	        			newInvoicesData.EPIMemberLevel = getProfileData.EPIMemberLevel;
	        			newInvoicesData.CHMemberLevel = getProfileData.CHMemberLevel;
	        			
	        			newInvoicesData.membershipNumber = getProfileData.membershipNumber;
	        		 	newInvoicesData.membershipType_ = getProfileData.membership_Type;
	        			newInvoicesData.membershipTier = getProfileData.membershipTier;
	        			String status1 = GetReservationData.Reservation_status;
	        			newInvoicesData.Reservation_status =status1 ;	        			
	        			
	        			System.out.println("Reservation_Status in jsp: "+status1);
	        			
	        			
	        			HashMapData.mapNewInvoices.put(request.getParameter("ReservId"), newInvoicesData);
	        			newInvoicesData = HashMapData.mapNewInvoices.get(request.getParameter("ReservId"));	        			
	        			
	        			//code to fetch the member data
	        			GetMemberData memberData = new GetMemberData(newInvoicesData.MembershipNumberTIC, request.getParameter("ReservId"),request.getParameter("Property"));
	        			Thread threadMember = new Thread(memberData);
	        			threadMember.start();
	        			threadMember.join();
	        			
	        			
	        			
	        			HashMapData.mapMemberData.put(request.getParameter("ReservId"), memberData);
						String id = request.getParameter("ReservId");
	        			GetMemberData getMemberData = HashMapData.mapMemberData.get(id);
	        			
	        			newInvoicesData.MembershipTier = getMemberData.MembershipTier;
	        			
	        			if(getMemberData.TICPointsBalance != null && !getMemberData.TICPointsBalance.equalsIgnoreCase(""))
	        			{
	        				newInvoicesData.TICPointsBalance = getMemberData.TICPointsBalance;
	        				
	        			}else
	        			{
	        				newInvoicesData.TICPointsBalance = "0";
	        			}
	        			
	        			
	        			
	        			//code for fetching the list of vouchers available for member
	        		/* 	 GetVouchersData vouchersData = new GetVouchersData();
	        			vouchersData.getVouchers(newInvoicesData.MembershipNumber, request.getParameter("ReservId"));
	        			HashMapData.mapVoucher.put(request.getParameter("ReservId"), vouchersData); 
	        		 */	
	        			
	        		}else
	        		{
	        			newInvoicesData.MembershipNumberTIC = "Member Not Enrolled";
	        			newInvoicesData.MembershipNumber = " ";
	        			newInvoicesData.TICPointsBalance = "0";
	        			
	        		}
	        		
	        		HashMapData.mapNewInvoices.put(request.getParameter("ReservId"), newInvoicesData);
	        		newInvoicesData = HashMapData.mapNewInvoices.get(request.getParameter("ReservId"));	        			        			        		        		        	
            %>	
            
            <%-- <%!
            	NewInvoicesData newInvoicesData = HashMapData.mapNewInvoices.get(servletRequest.getParameter("ReservId"));
            %> --%>
            		

        <input type="hidden" id="CHMemberNumber" value="<%=getProfileData.CHMemberNumber%>"/>
        <input type="hidden" id="EPIMemberNumber" value="<%=getProfileData.EPIMemberNumber%>"/>
        <input type="hidden" id="EPIMemberLevel" value="<%=getProfileData.EPIMemberLevel%>"/>
        <input type="hidden" id="CHMemberLevel" value="<%=getProfileData.CHMemberLevel%>"/>
        <input type="hidden" id="Reservation_Status" value="<%=newInvoicesData.Reservation_status%>"/>
         <input type="hidden" id="TICMemberNumber" value="<%=getProfileData.TICMemberNumber%>"/> 


		<div style="display: flex;flex-direction: column;background-color: #EAECEE;;width :100%" class="page-content" >
				<div class="navigation_bar">
					
						<div class="title" style="font-size: 1.74vw">
							<img class="logo" src="images/logo.png" alt="">
							
						</div>
                        <p
							class="MUITitle" style="text-align: center; width: 80%; font-size: xx-large; padding: 0; padding-top: 7px; list-style: none; font-family: serif; color: #896633;">Taj Reservation Gateway</p>
						<div
							style="display: inline-block; float: right; margin-right: 20px; margin-top: -51px; margin-bottom: 5px;" class="closeBTN">
							<table>
								<tr>
									<td><span style="font-weight: bold; visibility: hidden;"><b><span>UserName</span></b></span>
									</td>
								</tr>
								<tr>
									<td style="text-align: center;">
									<span><a href="InvalidateSessionServlet?GlobalReservationNumber=<%=request.getParameter("ReservId") %>" class="userpopupbtn" style="text-align: center; text-decoration: blink; color: #896633; float: right;">Close</a></span>
									</td>
								</tr>
							</table>
						</div>	
				</div>

				<div class="topnav" style="display: flex;flex-wrap: wrap;">
				   <div class="parentmenucustom" style="width:50%">
                    <label class="menucustom" style=" font-family:serif; font-size:x-large; padding-left:5%"><%=getReservationData.PropertyFullName %></label>
                   </div>
                    <div class="availVouchers" style="width: 50%; display: flex; justify-content: flex-end;">
                       <input type="button" id="btnAvailVoucherShow" class="btn btn-default MobileAvailOff" value="Avail voucher" style= "font-family:serif; font-size:large; margin-right:15px !important; color:#896633; background-color:#80cbc4;height: 88%;margin-top: 2px;" data-toggle="modal" data-target="#modalVoucherMain" ng-click="getVouchers()" />
                       <input type="button" id="btnOffersShow" class="btn btn-default MobileAvailVou" value="Available Offers" style= "font-family:serif; font-size:large; margin-right:15px !important; color:#896633; background-color:#80cbc4; height: 88%;margin-top: 2px;" data-toggle="modal" data-target="#modalOffersMain" ng-click="getOffers()" />
                    </div>
                </div>
                
		</div>
		                        
	
	<div id="DivLoading">
					</div>
					<div id="GravtyGCloadingUIHover" style="display: none; width: 400px; padding-top: 30px; padding-bottom: 20px; border-radius: 10px; background-color: #6d909c;">
                            <center>
                                <div class="loader"></div>
                                <br />
                                <label style="color: white;" id="lblUIHover">Loading</label>
                                <br />
                                <label style="color: white;">Please wait...</label>
                                <br />
                            </center>
                        </div>

					
	
	<br/>
	<div class="container-fluid" style="padding-left: 10px; padding-right: 10px;">
	<div class="jumbotron"  style="background-color: #EAECEE; margin:0px; padding:0px;">
        <br />
        <input type="hidden" id="VoucherPinGravty" value=""/>   
        <input type="hidden" id="Memtype" value=""/>
        <input type="hidden" id="RedirectUrl" value=""/>
        <input type="hidden" id="confNumber" value="<%=getReservationData.ConfirmationNo%>"/>     
                       
        
            <table cellspacing="0px" border="0" width="100%" style="margin:0px; padding:0px;">
                <tr class="colomnDataForMR">
                    <td class="childTableMR" align="center" style="width:20%;">
                       
                        <table class="table-responsive" style="margin:0px; text-align:justify;" border="0">
							<tr class="tableStyleouter">
                                <td><label class="tableStyle">Guest Name</label></td>
                                <td><label class="tableStyle">:</label></td>
                                <td><label class="tableStyle"><%=newInvoicesData.FirstName %> <%=newInvoicesData.LastName %></label></td>
                            </tr>
                            <tr class="tableStyleouter">
                                <td><label class="tableStyle">Confirmation No</label></td>
                                <td><label class="tableStyle">:</label></td>
                                <td><label class="tableStyle" id="labelConfirmationDisplay"><%=getReservationData.ConfirmationNo%></label></td>
                            </tr>
                            <tr class="tableStyleouter">
                                <td><label class="tableStyle">PMS ID</label></td>
                                <td><label class="tableStyle">:</label></td>
                                <td><label class="tableStyle"><%=newInvoicesData.PMSId %></label></td>
                            </tr>
                            <tr class="tableStyleouter">
                                <td><label class="tableStyle">MDM ID</label></td>
                                <td><label class="tableStyle">:</label></td>
                                <td><label class="tableStyle"><%=newInvoicesData.MDMPartyNumber %></label></td>
                            </tr>
                        </table>

                     </td>
                    <td class="childTableMR" align="center" style="width:20%;">
                        
                         <table class="table-responsive" style="margin:0px; text-align:justify;" border="0">

                            
                            <tr class="tableStyleouter">
                                <td><label class="tableStyle">Address Line</label></td>
                                <td><label class="tableStyle">:</label></td>
                                <td><label class="tableStyle" style="word-wrap:inherit"><%=newInvoicesData.AddressLine %></label></td>
                            </tr>
                            <tr>
                                <td><label class="tableStyle">Country</label></td>
                                <td><label class="tableStyle">:</label></td>
                                <td><label class="tableStyle"><%=newInvoicesData.CountryCode %></label></td>
                            </tr>
                            <tr>
                                <td><label class="tableStyle">Arrival</label></td>
                                <td><label class="tableStyle">:</label></td>
                                <td><label class="tableStyle" id="labelArrivalDisplay"><%=reservationData.ArrivalDate %></label></td>
                            </tr>
                            <tr>
                                <td><label class="tableStyle">Departure</label></td>
                                <td><label class="tableStyle">:</label></td>
                                <td><label class="tableStyle" id="labelDepartureDisplay"><%=reservationData.DepartureDate %></label></td>
                            </tr>
                        </table>
                        
                      </td>
                      <td class="childTableMR" align="center" style="width:30%;">
                        
                         <table class="table-responsive" style="margin:0px; text-align:justify;" border="0">
							<tr>
                                <td><label class="tableStyle">Member Number</label></td>
                                <td><label class="tableStyle">:</label></td>
                                
                                <td>
                                	<input class="tableStyle" type="text" id="txtMemberNumberTIC" value='<%=newInvoicesData.membershipNumber %>' 
                                	style="background-color: #EAECEE; border: 0px; font-weight: bold;" readonly="readonly">
                                </td>
                            </tr>
                             <tr>
                                <td><label class="tableStyle">Membership Type</label></td>
                                <td><label class="tableStyle">:</label></td>

                                <td>
                                    <input class="tableStyle" type="text" value='<%=newInvoicesData.membershipType_ %>'
                                           style="background-color: #EAECEE; border: 0px; font-weight: bold;" readonly="readonly">
                                </td>
                            </tr>
                            <tr>
                                <td><label class="tableStyle">Tier</label></td>
                                <td><label class="tableStyle">:</label></td>
                                
                                <td>
                                	<input class="tableStyle" type="text" id="txtMemberNumber" value='<%=newInvoicesData.membershipTier %>' 
                                	style="background-color: #EAECEE; border: 0px; font-weight: bold;" readonly="readonly">
                                </td>
                            </tr>
                            
                           <tr>
                                <td><label class="tableStyle">Mobile Number</label></td>
                                <td><label class="tableStyle">:</label></td>
                                
                                <td>
                                	<input class="tableStyle" type="text" id="txtMemberNumberTPM" value='<%=newInvoicesData.MembershipNumberTPM %>' 
                                	style="background-color: #EAECEE; border: 0px; font-weight: bold;" readonly="readonly">
                                </td>
                            </tr>
                             <tr>
                                <td><label class="tableStyle">Status</label></td>
                                <td><label class="tableStyle">:</label></td>
                                
                                
                                <td>  
                                   <%

                                   if ("CHECKED OUT".equalsIgnoreCase(newInvoicesData.Reservation_status)) {

                                     %>
                                     <script>

                                             window.location.href = 'checkout.jsp';
                                         </script>
                                       <%

                                        return;

                                        }

                                       %>
 
                                
                                	<input class="tableStyle" type="text" id="Reservation_status_" value='<%=newInvoicesData.Reservation_status %>' 
                                	style="background-color: #EAECEE; border: 0px; font-weight: bold;" readonly="readonly">
                                </td>
                            </tr>
                        </table>
                        
                      </td>
                       <%
                            	GetReservationData resvData = HashMapData.mapReservationData.get(request.getParameter("ReservId"));
                            	String resvInvoiceStatus = resvData.ResvInvoiceStatus;
                            	if(resvInvoiceStatus.equalsIgnoreCase("NOT ENABLED"))
                            	{
                                    %>
                                    <td class = "neu-coins"align="center" style="width:20%;">
                                     	<table class="table-responsive" style="margin:0px; text-align:justify;" border="0">
                  						 <tr>
                                              <td><label class="tableStyle">Neu Coins</label></td>
                                              <td><label class="tableStyle">:</label></td>
                                              
                                               <td>
                                              	<input class="tableStyle" type="text" id="txtTICPoints" value='<%=newInvoicesData.TICPointsBalance %>'
                                              	style="background-color: #EAECEE; border: 0px; font-weight: bold;" readonly="readonly">
                                              </td>
                                          </tr>
                                          <tr>
                                              <td><label class="tableStyle">Room No</label></td>
                                              <td><label class="tableStyle">:</label></td>
                                              <td><label class="tableStyle"><%=reservationData.RoomNo %></label></td>
                                          </tr>
                                      </table>
                                   </td>
                                   <%
                            	}
                            	else
                            	{
                            %>
                      <td class="childTableMR" align="center" style="width:30%;">
                       	<table class="table-responsive" style="margin:0px; text-align:justify;" border="0">
    						 <tr>
                                <td><label class="tableStyle">TIC Points</label></td>
                                <td><label class="tableStyle">:</label></td>
                                
                                 <td>
                                	<input class="tableStyle" type="text" id="txtTICPoints" value='<%=newInvoicesData.TICPointsBalance %>'
                                	style="background-color: #EAECEE; border: 0px; font-weight: bold;" readonly="readonly">
                                </td>
                            </tr>
                            <tr>
                                <td><label class="tableStyle">Room No</label></td>
                                <td><label class="tableStyle">:</label></td>
                                <td><label class="tableStyle"><%=reservationData.RoomNo %></label></td>
                            </tr>
                           
                            <tr>
                                <td><label class="tableStyle">Payment Link</label></td>
                                <td><label class="tableStyle">:</label></td>
                                 <td><label class="tableStyle"><%=resvData.ResvInvoiceStatusMsg %></label></td>
                            </tr>
                            <tr>
                                <td><label class="tableStyle"><%=resvData.ResvInvoicePaymentStatusLabel %></label></td>
                                <td><label class="tableStyle">:</label></td>
                                
                                 <td>
                                 	<%
                                 		if(resvInvoiceStatus.equals("SUCCESS"))
                                 		{
                                 			if(resvData.ResvInvoicePaymentStatus.equals("Customer Paid"))
                                 			{
                          				%>
                          					<button type="button" class="btn btn-success tableStyle"><%=resvData.ResvInvoicePaymentStatus %></button>
                          				<%
                                 			} else {
                                 		%>
                                     			<button type="button" class="btn btn-primary tableStyle" ng-click="ccAvenueHandler('ResendInvoice')">Resend</button>
                                     	<%
                                 			}
                                 	
                                 		} else if(resvInvoiceStatus.equals("FAILED"))
                                 		{
                                 	%>
                                 			<button type="button" class="btn btn-success tableStyle" ng-click="ccAvenueHandler('createInvoice')">Create</button>
                                 	<%
                                 		}
                                 	%>
                                 	
                                 </td>
                            </tr>
                        </table>
                     </td>
                     <%
                     	}
                     %>
                </tr>
            </table>
        <br />
        </div>
        </div>

	<br/>
	
	<div class="topnavBar">
		<span><label style="margin-left: 50px; font-size: medium;">Invoice Details</label></span>
	</div>
	
	<br />

	<div>
		
	</div>

	<div class="folios" style="width:100%;">
    <div class="splitLeft">
        <div class="container-fluid" style="margin: 0px; padding: 0px; margin-left: 40px;">
            <div class="jumbotron" style="margin: 0px; padding: 0px;">
                <center>
      <div>
         <table
            class="table table-hover table-responsive table-bordered"
            border="0" id="myTable" style="text-align: center; background-color: white;">
					<tr>
						<th style="text-align: center;" title="Select All"><input
							type="checkbox" id="checkSelect" onchange="selectAll()" /></th>
						<th style="text-align: center;">Window</th>
						<th style="text-align: center;">Name</th>
						<th style="text-align: center;">Amount</th>
					</tr>
            
           
            	
            		
           		<%
           		//code to clear the existing value of CurrentBalance - Total bill amount
           		newInvoicesData = HashMapData.mapNewInvoices.get(request.getParameter("ReservId"));
				newInvoicesData.CurrentBalance = 0;
				HashMapData.mapNewInvoices.put(request.getParameter("ReservId"), newInvoicesData);
				System.out.println(newInvoicesData);
				newInvoicesData = HashMapData.mapNewInvoices.get(request.getParameter("ReservId"));
				JSONObject completeInvoiceDetails = new JSONObject(newInvoicesData.invoiceResponse);
				System.out.println("for CompleteInvoicesDeatils"+completeInvoiceDetails);
				
				JSONArray reservationFolioWindows = null;
				try {
					reservationFolioWindows = completeInvoiceDetails.getJSONObject("reservationFolioInformation").getJSONObject("reservationInfo").getJSONArray("reservationFolioWindows");
					System.out.println(reservationFolioWindows);
                } catch (JSONException e) {
                    e.printStackTrace();
               }
				System.out.println("for test"+completeInvoiceDetails);
				System.out.println("for test"+reservationFolioWindows);
           		StoreInvoiceDataMap storInvoiceDatMap = new StoreInvoiceDataMap();
						if(reservationFolioWindows != null){
                		for(int i=0; i<reservationFolioWindows.length(); i++)
                		{
                			if(reservationFolioWindows.getJSONObject(i).isNull("folioWindowNo") && reservationFolioWindows.length() <= 1) break;
                			String payeeName = reservationFolioWindows.getJSONObject(i).getJSONObject("payeeInfo").getString("payeeName");
                			int WindowNo = reservationFolioWindows.getJSONObject(i).getInt("folioWindowNo");
                			double strAmount = reservationFolioWindows.getJSONObject(i).getJSONObject("balance").getDouble("amount");
                			System.out.println("strAmount"+strAmount);
                			double TotalAmount = strAmount;
                			String CurrencyCode = "";
                			System.out.println("TotalAmount"+TotalAmount);
                			if(TotalAmount <= 0)
                				continue;
                			/*Need to write code for fetch invoice inner details*/
                			//JSONArray innerDetails =
                			JSONArray innerDetails = null;
                			try {
                				innerDetails = completeInvoiceDetails.getJSONObject("reservationFolioInformation").getJSONArray("folioWindows");
			                } catch (JSONException e) {
			                    e.printStackTrace();
			               }
                			System.out.println("innerDetails "+innerDetails);
                			try {
                				 for(int j=0;j<innerDetails.length();j++){
                    		 		System.out.println(innerDetails.getJSONObject(j).getInt("folioWindowNo"));
                    		 		if(innerDetails.getJSONObject(j).getInt("folioWindowNo") == WindowNo){
                    					CurrencyCode = innerDetails.getJSONObject(j).getJSONObject("revenue").getString("currencyCode");
                    				}
                    		 	} 
                				/* for (int j = 0; j < innerDetails.length(); j++) {
                                  JSONObject currentDetail = innerDetails.getJSONObject(j);
                                  if (currentDetail.has("paymentMethod")) {
                                     JSONObject paymentMethod = currentDetail.getJSONObject("paymentMethod");
                                     if (paymentMethod.has("folioView") && paymentMethod.getInt("folioView") == WindowNo) {
                                       CurrencyCode = currentDetail.getJSONObject("revenue").getString("currencyCode");
                                        }
                                   }else {
                                       System.out.println("Key 'paymentMethod' not found for entry " + j);
                                    }
                                   } */
			                      } catch (JSONException e) {
			                            e.printStackTrace();
			                       }
                			
                			double OriginalCurrencyTotalAmount = TotalAmount;
                			
                			 CurrencyConverter currencyConverter = new CurrencyConverter();
                			currencyConverter.convertCurrency(CurrencyCode, request.getParameter("ReservId"), request.getParameter("Property") ); 

                			newInvoicesData.CurrentBalance = newInvoicesData.CurrentBalance + TotalAmount;
                			System.out.println("Current Balance:\t" + newInvoicesData.CurrentBalance);
                			
                			HashMapData.mapNewInvoices.put(request.getParameter("ReservId"), newInvoicesData);
                			newInvoicesData = HashMapData.mapNewInvoices.get(request.getParameter("ReservId"));
                			
                			String stringWindowNo = Integer.toString(WindowNo);
                			
                			StoreInvoiceDetails invoiceDetails = new StoreInvoiceDetails(stringWindowNo,payeeName,TotalAmount,OriginalCurrencyTotalAmount);
                			storInvoiceDatMap.addStoreInvoices(stringWindowNo, invoiceDetails);
                			HashMapData.mapInvoices.put(request.getParameter("ReservId"), storInvoiceDatMap);
                    		
                			
                			
                		
           				
           				%>
           				
		           			<tr>
		            		<td><input type="checkbox" name="checkbox" onchange="validateAll()"/> </td>
		                	<td><%=WindowNo%></td>
		                	<td><%=payeeName%></td>
		                	<td><%=String.format(Locale.US, "%.2f", TotalAmount)%></td>
		            		</tr>
           				
           				<%
           				
           			}
                		}
           		%>
            	<tr style="border: 0px; border-style: none; background-color: #fff;" class="text-success">
            		<td style="border: 0px; border-style: none;"></td>
                	<td style="border: 0px; border-style: none;"></td>
                	<td style="border: 0px; border-style: none;" align="right"><label>Total Amount:</label></td>
                	<td style="border: 0px; border-style: none;"><label><%=String.format(Locale.US, "%.2f", newInvoicesData.CurrentBalance) %></label> </td>
            		</tr>
            		
            	
            
        </table>
         </div>
   </center>
            </div>
        </div>
        </div>

    <div class="splitRight">



            <div class="container-fluid" style=" padding-bottom: 0px; padding-top: 0px;">
                <div class="jumbotron" style="width:94%; background-color:white; padding-bottom: 0px; padding-top: 0px; border-radius:10px; padding-left: 15px !important; padding-right: 15px !important;">
                    <center>
                        <br />



                        <!-- divFirstStep Start -->

                        <div id="divFirstStep">

                            <span style="float: left !important; padding-left: 10% !important; font-weight: bold; color: cadetblue">Select Payment Mode</span>
                            <br />
                            
                                <table class="table-hover" border="0">
                                <tr>
                                    <td class="pull-left">
                                        <label><input type="radio" name="rdoType" value="point" title="Pay using Points" style="margin-right:10px;" onchange="divFirstStep()" />Pay using Neu Coins</label>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="pull-left">
                                        <label id="lblPayUsingGiftCard"><input type="radio" name="rdoType" id="rdoPayUsingGiftCard" value="card" title="Pay using Giftcard" style="margin-right:10px;" onchange="divFirstStep()" />Pay using Giftcard</label>
                                    </td>
                                </tr>

                            </table>
                            
                            
                        </div>

                        <!-- divFirstStep End -->

                        <!-- divTwoPointOne Start -->

                        <div id="divTwoPointOne" style="display: none;">

                            <table class="table-hover" border="0">
                                <tr>
                                    <td class="pull-left">
                                        <label>
                                            <input type="radio" id="rdoTIC" name="rdoPayType" value="tic" title="Pay using Points" style="margin-right: 10px;" onchange="CalculateAmount()" />Pay using TIC points</label>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="pull-left">
                                        <label style="display: none; visibility: hidden;">
                                            <input type="radio" id="rdoEpicure" name="rdoPayType" value="epicure" title="Pay using Point" style="margin-right: 10px; visibility: hidden; display: none;" disabled="disabled" />Pay using Epicure points</label>
                                    </td>
                                </tr>

                            </table>

                            <input class="btn btn-info btn-lg" type="button" onclick="btnGoToDivFirstStep()" value="back" />
                        </div>

                        <!-- divTwoPointOne End -->

                        <!-- divOnePointTwo Start -->

                        <div id="divOnePointTwo" style="display:none;">

                            <table class="table-hover" border="0">
                                <tr>
                                    <td class="pull-left">
                                        <label><input type="radio" id="rdoCardSwipe" name="rdoPayType" value="cardSwipe" title="Pay using Giftcard" style="margin-right:10px;" onchange="CalculateAmount()"/>Giftcard swipe</label>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="pull-left">
                                        <label><input type="radio" id="rdoCardEnter" name="rdoPayType" value="card" title="Pay using Giftcard" style="margin-right:10px;" onchange="CalculateAmount()" />Enter Giftcard details</label>
                                    </td>
                                </tr>

                            </table>

                            <input class="btn btn-info" type="button" onclick="btnGoToDivFirstStep()" value="back" />

                        </div>

                        <!-- divOnePointTwo End -->

                     

                        <div id="divPayPoint" style="background-color:#cfdcd9; border-radius:15px; display:none">
                        <br/>
                        <h4 class="payUsingTIC"><b>Pay using TIC Points</b></h4>
                        <br/>
                            <table class="table-responsive">
                                <tr class="TIC-inside">
                                    <td class="pull-right" style="margin-right:20px;">
                                        <label class="side-text" style="font-size: 0.95vw;">Total Amount</label>
                                    </td>
                                    <td style="padding-bottom:0.5em;" class="place-holder">
                                        <input class="text-center" type="text" id="txtTotalAmount" onchange="changeTotal()" style="border-radius:10px; border:0px; max-height:1; height:30px; font-weight:bold; width: 100%" />
                                    </td>
                                </tr>
                                <tr class="TIC-inside">
                                    <td class="pull-right" style="margin-right:20px;">
                                        <label class="side-text"style="font-size: 0.95vw;">TIC Points</label>
                                    </td>
                                    <td style="padding-bottom:0.5em;"class="place-holder">
                                        <input class="text-center" type="text" id="txtTIC" onchange="changeTIC()" style="border-radius:10px; border:0px; max-height:1; height:30px; font-weight:bold; width: 100%" />
                                    </td>
                                </tr>
                                <tr class="TIC-inside">
                                    <td class="pull-right" style="margin-right:20px;">
                                        <label class="side-text"style="font-size: 0.95vw;">Currency Rate Exchange </label>
                                    </td>
                                    <td style="padding-bottom:0.5em;"class="place-holder">
                                        <input class="text-center" type="text" id="RateEx" style="border-radius:10px; border:0px; max-height:1; height:30px; font-weight:bold; width: 100%" disabled="disabled"/>
                                    </td>
                                </tr>
                            </table>
                            <br />

							<input type="button" class="btn btn-primary" name="btnSubmit" value="Submit" onclick="Invoices()" />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input class="btn btn-info" type="button" onclick="btnGoToDivFirstStep()" value="back" />
                            
                            <br />
                            <br />
                        </div>
                        <br />
                        <br />
                        
                        <div id="divPayCard" style="background-color:#cfdcd9; border-radius:15px; display:none;">
                            <br />
                            <b>Enter Gift card details</b>
                            <br />
                            <br />

                            <table>
                                <tr>
                                    <td class="pull-right" style="margin-right:20px;">
                                        <label>GiftCard Number</label>
                                    </td>
                                    <td style="padding-bottom:0.5em;">
                                        <input class="text-center" type="text" id="txtCardNo" style="border-radius:10px; border:0px; max-height:1; height:30px; font-weight:bold; width: 100%" />
                                    </td>
                                </tr>
                                <tr>
                                    <td class="pull-right" style="margin-right:20px;">
                                        <label>Pin Number</label>
                                    </td>
                                    <td style="padding-bottom:0.5em;">
                                        <input class="text-center" type="password" id="txtCardPin" style="border-radius:10px; border:0px; max-height:1; height:30px; font-weight:bold; width: 100%" />
                                    </td>
                                </tr>
                                <tr>
                                    <td class="pull-right" style="margin-right:20px;">
                                        <label>Amount to pay</label>
                                    </td>
                                    <td>
                                        <input class="text-center" type="text" id="txtCardAmount" style="border-radius:10px; border:0px; max-height:1; height:30px; font-weight:bold; width: 100%" />
                                    </td>
                                </tr>
                            </table>
                            <br />





                            <input type="button" class="btn btn-primary" name="btnSubmit" value="Submit" onclick="Invoices()" style="margin-right: 20px;" />

                            <input type="button" class="btn btn-info" name="btnCheckBal" value="Check Balance" onclick="CheckGCBalance()" />

                            <label id="lblGCBalance"></label>

                            <br />
                            <br />

                        </div>

						<div id="divGiftCardSwipe" style="background-color:#cfdcd9; border-radius:15px; display:none;">
                            <br />
                            <b>Gift card</b>
                            <br />
                            <br />

                            <table>
                                <tr>
                                    <td class="pull-right" style="margin-right:20px;">
                                        <label>Amount to pay</label>
                                    </td>
                                    <td>
                                        <input class="text-center" type="text" id="txtGiftCardAmount" style="border-radius:10px; border:0px; max-height:1; height:30px; font-weight:bold; width: 100%" />
                                    </td>
                                </tr>
                            </table>
                            <br />

                            <input type="button" class="btn btn-primary" name="btnSubmit" value="Proceed" onclick="enableGCSwipemodal()" style="margin-right: 20px;" />
                            <br />
                            <br />

                        </div>

                        <br />


                    </center>

                </div>
            </div>
        </div>

    </div>


<!-- OTP Modal Start -->
    <!-- The Modal -->
    <div class="modal" id="modalOTP">
        <div class="modal-dialog">
            <div class="modal-content" style="background: #ffffff; min-width: 70%; max-width: 75%;">

                <!-- Modal Header -->
                <div class="modal-header" style="border: 0px;">
                    <h4 class="modal-title" style="font-weight: bold; font-size:large; color: #003ff7; font-family:'Times New Roman', Times, serif;">Pay by Point</h4>
                </div>

                <!-- Modal body -->
                <div class="modal-body" style="border: 0px;  padding:0px; margin:0px;">
                    <center>


                        <div class="well-sm" style="display:block; padding:0px; margin:0px;" id="modalBodyVerificationType">
                            <label style="text-align:center; font-display:block; font-size:large; color:#898e9e; font-family:'Times New Roman', Times, serif">Verify Identity using...</label>
                            <br />
                            <br />

                            <input class="btn btn-primary" type="button" id="btnEnableOTPModal" value="OTP" onclick="enableManualMemberNumberBody()" style="font-size: larger; margin-right:20px;" />
                           <!--   <input class="btn btn-primary" type="button" id="btnEnableCardSwipeModal" value="Membership Card" onclick="enableCardSwipeBody()" style="font-size: larger" />-->

                            <div class="modal-footer" style="border: 0px;">

                                <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                            </div>

                        </div>


                        <div id="modalBodyCardSwipe" style="display:none; padding:0px; margin:0px;">
                            <label style="text-align:center; font-display:block; font-size:medium; color:#898e9e; font-family:'Times New Roman', Times, serif">Please Swipe the Membership Card</label>
                            <br />
                            <input type="password" id="txtMemberCardNumberHidden" onchange="cardSwiped()" />
                            <br />
                            <input type="button" value="Next" />

                            <div class="modal-footer" style="border: 0px;">

                                <button type="button" class="btn btn-danger" onclick="payPointsGoBackBtn()">back</button>
                            </div>
                        </div>

                        <div id="modalBodyOTP" style="display:none; padding:0px; margin:0px;">
                            <table style="margin: 0px; padding: 0px; width: 50%;">
                                <tr>
                                    <td>
                                        <input type="password" id="txtOTP" placeholder="Enter OTP" style="border-style: dashed;border-radius: 10px;height: 40px;text-align: center;text-shadow: none;" />
                                    </td>
                                   <!-- <td style="padding-left:20px; text-align:center">
                                        <input type="button" id="btnResendOTP" class="btn btn-warning" value="Resend OTP" onclick="sendOTP()" />
                                    </td>  --> 
                                </tr>
                            </table>

                            <div class="modal-footer" style="border: 0px;">
                                <input type="button" class="btn btn-success" value="Submit" onclick="Invoices()" />
                                <button type="button" class="btn btn-danger" onclick="payPointsGoBackBtn()">back</button>
                            </div>

                        </div>

						<!-- Code for manual entering membership number for OTP -->
                        <div id="modalManualMemberNumberBody" style="display:none; padding:0px; margin:0px;">
                            <label style="text-align:center; font-display:block; font-size:medium; color:#898e9e; font-family:'Times New Roman', Times, serif">Please enter membership number to proceed</label>
                            <br />
                            <br />                            
                            <input type="text" id="txtOtpMemberNumber" style="border-style: groove;border-radius: 10px;height: 40px;text-align: center;text-shadow: none;"/>
                            

                            <div class="modal-footer" style="border: 0px;">
                                <input type="button" class="btn btn-success" value="Proceed" onclick="validateMemberAndSendOTP()" style="margin-right:15px;" />
                                <button type="button" class="btn btn-danger" onclick="payPointsGoBackBtn()">back</button>
                            </div>
                        </div>

                        <!-- Loading UI -->
                        <div id="loadingUIHover" style="display: none; width: 400px; padding-top: 30px; padding-bottom: 20px; border-radius: 10px; background-color: #6d909c;">
                            <center>
                                <div class="loader"></div>
                                <br />
                                <label style="color: white;" id="lblUIHover">Sending OTP</label>
                                <br />
                                <label style="color: white;">Please wait...</label>
                                <br />
                            </center>
                        </div>

                    </center>

                </div>

            </div>
        </div>
        <!-- Snackbar -->
        <div id="snackbar"><label id="lblOTPRes"></label></div>



    </div>
    <!-- OTP Modal End -->
      

    <!-- Giftcard Modal Start -->
    <div class="modal" id="modalGC">
        <div class="modal-dialog">
            <div class="modal-content" style="background: #ffffff; min-width: 70%; max-width: 75%;">

                <!-- Modal Header -->
                <div class="modal-header" style="border: 0px;">
                    <h3 class="modal-title" style="font-weight: bold; color: #003ff7;">Pay by Point</h3>
                </div>

                <!-- Modal body -->
                <div class="modal-body" style="border: 0px;  padding:0px; margin:0px;">
                    <center>

                        <div id="modalGCBodyCardSwipe" style="padding:0px; margin:0px;">
                            <label style="text-align:center; font-display:block; font-size:large; color:#898e9e;">Please Swipe the GiftCard to proceed</label>
                            <br />
                            <br />
                            <input type="password" id="txtGCCardNumber" onchange="cardSwipedGC()" />
                            
                            <input type="button" class="btn btn-success" value="Next" />

                            <div class="modal-footer" style="border: 0px; padding-top:0px !important">

                                <button type="button" class="btn btn-danger" onclick="GCSwipeGoBackBtn()">Close</button>
                            </div>
                        </div>

                        <!-- Loading UI -->
                        <div id="loadingUIHoverGC" style="display: none; width: 400px; padding-top: 30px; padding-bottom: 20px; border-radius: 10px; background-color: #6d909c;">
                            <center>
                                <div class="loader"></div>
                                <br />
                                <label style="color: white;" id="lblUIHoverGC">Validating card...</label>
                                <br />
                                <label style="color: white;">Please wait...</label>
                                <br />
                            </center>
                        </div>

                    </center>

                </div>

            </div>
        </div>

    </div>
    <!-- Giftcard Modal End -->
    
    
    <!--  Gravty 3 buttons PIN OTP Cardswipe modal Start -->
    
    <div class="modal" id="GravtymodalOTP" style=" z-index: 1100;" >
        <div class="modal-dialog" >
            <div class="modal-content" style="background: #ffffff; min-width: 70%; max-width: 75%;">

                <!-- Modal Header -->
                <div class="modal-header" style="border: 0px;">
                    <h4 class="modal-title" style="font-weight: bold; font-size:large; color: #003ff7; font-family:'Times New Roman', Times, serif;">Avail Voucher</h4>
                </div>

                <!-- Modal body -->
                <div class="modal-body" style="border: 0px;  padding:0px; margin:0px;">
                    <center>


                        <div class="well-sm" style="display:block; padding:0px; margin:0px;" id="GravtymodalBodyVerificationType">
                            <label style="text-align:center; font-display:block; font-size:large; color:#898e9e; font-family:'Times New Roman', Times, serif">Select Any Option To Avail Voucher</label>
                            <br />
                            <br />

                            <input class="btn btn-primary otp_button" type="button" id="btnEnableOTPModal" value="OTP" onclick="GravtyenableOtpBody()" style="font-size: larger; margin-right:20px;" />
                            <input class="btn btn-primary card_swipe_button" type="button" id="btnEnableCardSwipeModal" value="Card Swipe" onclick="GravtyenableCardSwipeBody()" style="font-size: larger" />
							 <input class="btn btn-primary pin_button" type="button" id="btnEnableOTPModal" value="PIN" onclick="GravtyenablePINBody()" style="font-size: larger; margin-right:20px;" />
                            <div class="modal-footer" style="">

                                <input type="button" value="Close" class="btn btn-danger close_button" data-dismiss="modal" style="padding: 10px; margin: 10px;"></input>
                            </div>

                        </div>                                                  
                        
                        
							<div class="well-sm" style="display:none; padding:0px; margin:0px;" id="GravtymodalUrlRedirect">
                            <label style="text-align:center; font-display:block; font-size:large; color:#898e9e; font-family:'Times New Roman', Times, serif">Sucessfully Availed. Navigating to Home Page</label>
                            <br />
                            <br />

                            <input class="btn btn-primary" type="button" id="btnEnableOTPModal" value="OK" onclick="GravtyUrlRedirect()" style="font-size: larger; margin-right:20px;" />
                            <div class="modal-footer" style="">                               
                            </div>

                        </div>

                        <div id="GravtymodalBodyCardSwipe" style="display:none; padding:0px; margin:0px;">
                            <label style="text-align:center; font-display:block; font-size:medium; color:#898e9e; font-family:'Times New Roman', Times, serif">Gravty- Please Swipe the Membership Card</label>
                            <br />
                            <input type="password" id="GravtytxtMemberCardNumberHidden" onchange="GravtycardSwiped()" />
                            <br />
                            <input type="button" value="Next" />

                            <div class="modal-footer" style="border: 0px;">

                                <button type="button" class="btn btn-danger" onclick="GravtypayPointsGoBackBtn()">back</button>
                            </div>
                        </div>

                        <div id="GravtymodalBodyOTP" style="display:none; padding:0px; margin:0px;">
                             <label style="text-align:center; font-display:block; font-size:medium; color:#898e9e; font-family:'Times New Roman', Times, serif">Enter OTP</label>
                             
                             
                            <table style="margin: 0px; padding: 0px; width: 50%;">
                                <tr>
                                    <td>
                                        <input type="password" id="GravtyOTP" placeholder="Enter OTP" style="border-style: dashed;border-radius: 10px;height: 40px;text-align: center;text-shadow: none;" minlength="6" required/>
                                    </td>
                                   <td style="padding-left:20px; text-align:center">
                                        <input type="button" id="btnResendOTP" class="btn btn-warning" value="Resend OTP" onclick="GravtyenableOtpBody()" />
                                    </td>  
                                </tr>
                            </table>
							<br>
							<div id="countdown"></div>
							
                            <div class="modal-footer" style="border: 0px;">
                                <input type="button" class="btn btn-success" value="Submit" onclick="GravtycardSwiped()" />
                                <button type="button" class="btn btn-danger" onclick="GravtypayPointsGoBackBtn()">back</button>
                            </div>

                        </div>

							<div id="GravtymodalBodyPIN" style="display:none; padding:0px; margin:0px;">
                            <label style="text-align:center; font-display:block; font-size:medium; color:#898e9e; font-family:'Times New Roman', Times, serif">Enter PIN</label>
                            <table style="margin: 0px; padding: 0px; width: 50%;">
                                <tr>
                                    <td>
                                        <input type="password" id="txtPIN" placeholder="Enter PIN" style="border-style: dashed;border-radius: 10px;height: 40px;text-align: center;text-shadow: none;" />
                                    </td>
                                   <!-- <td style="padding-left:20px; text-align:center">
                                        <input type="button" id="btnResendOTP" class="btn btn-warning" value="Resend OTP" onclick="sendOTP()" />
                                    </td>  --> 
                                </tr>
                            </table>

                            <div class="modal-footer" style="border: 0px;">
                                <input type="button" class="btn btn-success" value="Submit" onclick="GravtycardSwiped()" />
                                <button type="button" class="btn btn-danger" onclick="GravtypayPointsGoBackBtn()">back</button>
                            </div>

                        </div>
                        
                         

						<!-- Code for manual entering membership number for OTP -->
                        <div id="modalManualMemberNumberBody" style="display:none; padding:0px; margin:0px;">
                            <label style="text-align:center; font-display:block; font-size:medium; color:#898e9e; font-family:'Times New Roman', Times, serif">Please enter membership number to proceed</label>
                            <br />
                            <br />                            
                            <input type="text" id="txtOtpMemberNumber" style="border-style: groove;border-radius: 10px;height: 40px;text-align: center;text-shadow: none;"/>
                            

                            <div class="modal-footer" style="border: 0px;">
                                <input type="button" class="btn btn-success" value="Proceed" onclick="validateMemberAndSendOTP()" style="margin-right:15px;" />
                                <button type="button" class="btn btn-danger" onclick="GravtypayPointsGoBackBtn()">back</button>
                            </div>
                        </div>

                        <!-- Loading UI -->
                        <div id="GravtyloadingUIHover" style="display: none; width: 400px; padding-top: 30px; padding-bottom: 20px; border-radius: 10px; background-color: #6d909c;">
                            <center>
                                <div class="loader"></div>
                                <br />
                                <label style="color: white;" id="lblUIHover">Loading</label>
                                <br />
                                <label style="color: white;">Please wait...</label>
                                <br />
                            </center>
                        </div>

                    </center>

                </div>

            </div>
        </div>
        <!-- Snackbar -->
        <div id="snackbar"><label id="lblOTPRes"></label></div>



    </div>
    
    <!-- OTP Modal End -->
    

    <!--  Gravty 3 buttons PIN OTP Cardswipe modal End -->
    
    
     <!-- Voucher Display Modal Start -->

    <div class="modal" id="modalVoucherMain" class="modal-box">
        <div class="modal-dialog" id="modal-dialog1" style="width: 90% !important; height: 90% !important; margin-right: 0px !important;">
            <div class="modal-content" id="modal-content1" style="background: #ccc; width: 90% !important; min-height: 90% !important; margin-bottom: 100px !important; padding-bottom: 50px !important; ">

                <!-- Modal Header -->
                <div class="modal-header" style="border: 0px;">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h3 class="modal-title" style="color: #896633; font-family:sans-serif; text-align:center; font-size:medium; font-weight:bold;">List of vouchers</h3>
                </div>

                <!-- Modal body -->
                <div class="modal-body" style="border: 0px;  padding:0px; margin:0px;">
               
                <label class="voucher-options" style="padding-left:15px"><b>Choose a Member Type:</b></label>
             <select class="clMemberType" id="clMemberType" data-attribute="class">
            <option value="all">ALL </option>
            <option value="Epicure">Epicure</option>
            <option value="Chambers">Chambers</option>
        <!--      <option value="Taj Club">Taj Club</option>    -->                                       
			</select>
			<!-- selection updtd vochers -->
			<label class="voucher-options" style="padding-left:15px"><b> Vouchers</b></label>
             <select class="VochersSelect" id="VochersSelect" data-attribute="class">
            <option value="Avalable" selected >Available Vouchers</option>
            <option value="Used">Used Vouchers</option>
             <option value="Expired">Expired Vouchers</option>
			</select>
			
			 
                <b class="voucher-options " style="padding-left:15px">   Membership Number:  <span id="MemType"></span></b>
                
                <b class="voucher-options" style="padding-left:29.5px">Membership Level:  <span id="MemLevel"></span></b>
                    
                    <center>

                        <div id="modalVoucherDisplay" style="padding:0px; margin:0px;">
                       
          
                            <table id="tblVoucher" cellspacing="0px" width="100%" class='table table-hover table-responsive table-bordered' border="0px" style="table-layout: fixed; max-width: 98% !important; width: 100% !important;">

                                <tr class='tablefont'>
                                	<th class="tablefontinner" style="width: 15%">Member Type</th>
                                    <th class="tablefontinner" style="width: 15%">Voucher Number</th>
                                    <th class="tablefontinner" style="width: 30%">Description</th>
                                    <th class="tablefontinner" style="width: 15%">Value</th>
                                    <th class="tablefontinner" style="width: 17%">Expiration Date</th>
                                    <th class="tablefontinner" style="width: 16%">Action</th>
                                </tr>
                                </table>
                                <!-- updated used vocher -->
                                <table id="UsedVocher" cellspacing="0px" width="100%" class='table table-hover table-responsive table-bordered' border="0px" style="table-layout: fixed; max-width: 98% !important; width: 100% !important;">

                                <tr class='tablefont'>
                                    <th class="tablefontinner">Member Type</th>
                                    <th class="tablefontinner">Voucher Number</th>
                                    <th class="tablefontinner">Description</th>
                                    <th class="tablefontinner">Value</th>
                                    <th class="tablefontinner">Used On</th>
									<th class="tablefontinner">Bill Data</th>
                                </tr>
                                </table>
                                <table id="ExpiredVocher" cellspacing="0px" width="100%" class='table table-hover table-responsive table-bordered' border="0px" style="table-layout: fixed; max-width: 98% !important; width: 100% !important;">

                                <tr class='tablefont'>
                                    <th class="tablefontinner" style="width: 15%">Member Type</th>
                                    <th class="tablefontinner" style="width: 15%">Voucher Number</th>
                                    <th class="tablefontinner" style="width: 15%">Description</th>
                                    <th class="tablefontinner" style="width: 15%">Value</th>
                                    <th class="tablefontinner" style="width: 15%">Expired On</th>									
                                </tr>
                                </table>
                                <!-- vochers -->
                            <table id="tblVouchers" cellspacing="0px" width="100%" class='table table-hover table-responsive table-bordered' border="0px" style="table-layout: fixed; max-width: 98% !important; width: 100% !important;">                                     
                                <tr class='tablefont_vouchers' ng-repeat="x in voucherData">
                                    <td class="tablefontinner">
                                        {{x.MemberType}}
                                    </td>
                          <!--          <script>  
                                    var testApp = angular.module('testApp', []);

                                    testApp.controller('TestAppCtrl', function ($scope) {
                                        $scope.data = x.VoucherNumber;
                                        stuff = $scope.data; // try this?
                                    });
                                    var   VoucherNumber= {{x.VoucherNumber}};
                                    if(VoucherNumber.indexOf(":") > -1)	{
                                    	var index= VoucherNumber.indexOf(":");
    								    VoucherNumber = VoucherNumber.substring(index+1,VoucherNumber.length);    								    
                                    }																	
                                    document.getElementById("1").innerHTML = VoucherNumber;
									</script>  -->  
                                    <td class="tablefontinner">
                                     {{x.VoucherNumber}}   
                                    </td>
                                    <td class="tablefontinner" style="word-wrap: break-word; align: left; margin: 0px !important;">
                                        <p align="left">{{x.Description}}</p>
                                    </td>
                                    <td class="tablefontinner">
                                        {{x.VoucherType}}
                                    </td>
                                    <td class="tablefontinner" >
                                        {{x.ExpirationDate}}
                                    </td>
                                    <td class="tablefontinner" id="btnavailVoucher">
                                        <input class="btn btn-success" type="button" value="Avail Voucher" name="btnAvailVoucher" id="btnAvailVoucher" ng-click=AvailVoucherGravty(x.VoucherNumber,x.MemberType) />
                                    </td>
                                </tr>

							

                            </table>
                            <!-- Expired vochers start-->
                                      
                            
                                                                <!-- vochers -->
                            <table id="ExpiredVochers" cellspacing="0px" width="100%" class='table table-hover table-responsive table-bordered' border="0px" style="table-layout: fixed; max-width: 98% !important; width: 100% !important;">                                     
                                <tr class='tablefont' ng-repeat="x in expiredVoucherData">
                                    <td class="tablefontinner">
                                        {{x.MemberType}}
                                    </td>
                                    <td class="tablefontinner">
                                     {{x.VoucherNumber}}   
                                    </td>
                                    <td class="tablefontinner" style="word-wrap: break-word; align: left; margin: 0px !important;">
                                        <p align="left">{{x.Description}}</p>
                                    </td>
                                    <td class="tablefontinner">
                                        {{x.VoucherType}}
                                    </td>
                                    <td class="tablefontinner" id="expiry_voucher">
                                        {{x.ExpirationDate}}
                                    </td>                                    
                                </tr>

							

                            </table>
                            
                            <!-- Expired vochers End-->
                            
                            
                            <!-- vochers -->
                            <table id="UsedVochers" cellspacing="0px" width="100%" class='table table-hover table-responsive table-bordered' border="0px" style="table-layout: fixed; max-width: 98% !important; width: 100% !important;">                                     
                                <tr class='tablefont' ng-repeat="x in usedVoucherData">
                                    <td>
                                        {{x.MemberTypeUsed}}
                                    </td>  
                                    <td >
                                     {{x.VoucherNumberUsed}}   
                                    </td>
                                    <td style="word-wrap: break-word; align: left; margin: 0px !important;">
                                        <p align="left">{{x.DescriptionUsed}}</p>
                                    </td>
                                    <td>
                                        {{x.VoucherTypeUsed}}
                                    </td>
                                    <td>
                                        {{x.UsedOn}}
                                    </td>
                                    <td style="word-wrap: break-word; text-align: left; margin: 0px !important;">
											<input class="btn btn-success" type="button" value="Get Bill Data" name="btnGetBillData" id="btnGetBillData" style="position: relative; left:17%" ng-click=btnGetBillData(x.MemberIdUsed,x.MemberTypeUsed,x.AvailmentBitIdUsed) />
											<p style="display:none" id="billNo">Bill NO: <span>{{billNo}}</span></p><br>
											<p style="display:none" id="usedAt">Redeemed at Hotel: <span>{{usedAt}}</span><span id="hLoc"></span></p>
									</td>
                                </tr>

                            </table>
                            <!-- usedvochers end -->
                            
         
                            
                            
                            
                            <div id="divVoucherError">
                                <h3 style="padding-top:75px;">
                                    No Vouchers available for this member
                                </h3>
                            </div>
                            
                        </div>

                        <!-- Loading UI -->
                        <div id="loadingUIHoverVoucher loadingUI" style="display: none; width: 400px; padding-top: 30px; padding-bottom: 20px; border-radius: 10px; background-color: #6d909c;">
                            <center>
                                <div class="loader loaderUI"></div>
                                <br />
                                <label  style="color: white;" id="lblUIHoverVoucher">Loading vouchers...</label>
                                <br />
                                <label style="color: white;" id="pleasewait">Please wait...</label>
                                <br />
                            </center>
                        </div>

                    </center>

                </div>

            </div>
        </div>

    </div>

    <!-- Voucher Display Modal End -->
    
    <!-- Offers Display Modal Start -->
    <div class="modal" id="modalOffersMain">
        <div class="modal-dialog" style="width: 90% !important; height: 90% !important; margin-right: 0px !important;">
            <div class="modal-content" style="background: #ccc; width: 90% !important; min-height: 90% !important; margin-bottom: 100px !important; padding-bottom: 50px !important; ">

                <!-- Modal Header -->
                <div class="modal-header" style="border: 0px;">
                    <button type="button" id="closebtn" class="close" data-dismiss="modal" >&times;</button>
                    <h3 class="modal-title" style="color: #896633; font-family:sans-serif; text-align:center; font-size:medium; font-weight:bold;">Offers available</h3>
                </div>

                <!-- Modal body -->
                <div class="modal-body" style="border: 0px;  padding:0px; margin:0px;">
                    <center>

                        <div id="modalOffersDisplay" style="padding:0px; margin:0px;">

                            <table id="tblOffers" cellspacing="0px" width="100%" class='table table-hover table-responsive table-bordered' border="0px" style="table-layout: fixed; max-width: 98% !important; width: 100% !important;">

                                <tr id="avail_table" class='tablefont'>
                                    <th style="width: 15%" id="offerId">Offer Id</th>
                                    <th>Offer Description</th>
                                    <th style="width: 15%" id="offEndDate">Offer End Date</th>
                                    <th style="width: 15%" id="RedemLeft">Redemptions Left</th>
                             <!--        <th style="width: 15%">Revenue Code</th>  -->
                                    <th style="width: 15%"" id="Avail_Action">Action</th>  
                                </tr>
                                <tr id="avail_list" class='tablefont' ng-repeat="x in offersData">
                                    <td>
                                        {{x.short_offerId}}
                                    </td>
                                    <td style="word-wrap: break-word; align: left; margin: 0px !important;">
                                        <p align="left">{{x.OfferName}}</p>
                                    </td>
                                    <td>
                                        {{x.OfferEndDate}}
                                    </td>
                         <!--               <td>
                                        {{x.RevenueAmount}}
                                    </td>
                                 <td>
                                        {{x.RevenueCode}}
                                    </td> -->
                                    <td>
                                        {{x.userRedemptionLimitLeft}}
                                    </td>
                                    <td class="Avail_action">
                                        <input class="btn btn-success" type="button" value="Avail Voucher" name="btnAvailVoucher" id="btnAvailVoucher" ng-click=TCPenableOtpBody(x.offerId,x.MembershipType) />
                                    </td>
                                </tr>

							

                            </table>
                            
                            <div id="divOffersError">
                                <h3 style="padding-top:75px;">
                                    No offers available for this member
                                </h3>
                            </div>
                            

                        </div>

                        <!-- Loading UI -->
                        <div class="UIOff" id="loadingUIHoverOffers" style="display: none; width: 400px; padding-top: 30px; padding-bottom: 20px; border-radius: 10px; background-color: #6d909c;">
                            <center>
                                <div class="loader"></div>
                                <br />
                                <label style="color: white;" id="lblUIHoverOffers">Loading offers</label>
                                <br />
                                <label style="color: white;">Please wait...</label>
                                <br />
                            </center>
                        </div>
       <div class="modal" id="TCPmodalOTP">
        <div class="modal-dialog">
            <div class="modal-content" style="background: #ffffff; min-width: 70%; max-width: 75%;margin-right: 150px;margin-top: 160px;">

                <!-- Modal Header -->
                <div class="modal-header" style="border: 0px;">
                    <h4 class="modal-title" style="font-weight: bold; font-size:large; color: #003ff7; font-family:'Times New Roman', Times, serif;">TCP Offer Redeem</h4>
                </div>

                <!-- TCP Modal body -->
                <center>
						<div id="TCPmodalBodyOTP" style="display:none; padding:0px; margin:0px;">
                             <label style="text-align:center; font-display:block; font-size:medium; color:#898e9e; font-family:'Times New Roman', Times, serif">Enter OTP</label>
                             
                             
                            <table style="margin: 0px; padding: 0px; width: 50%;">
                                <tr>
                                    <td>
                                        <input type="password" id="TCPOTP" placeholder="Enter OTP" style="border-style: dashed;border-radius: 10px;height: 40px;text-align: center;text-shadow: none;" minlength="6" required/>
                                    </td>
									 <!--commented add resend button-->
                                </tr>
                            </table>
							<br>
							<div id="TCPcountdown"></div>
							
                            <div class="modal-footer" style="border: 0px;">
                                <input type="button" class="btn btn-success" value="Submit" onclick="ValidateRedeem()" />
                                <button type="button" class="btn btn-danger" onclick="TCPBackBtn()">back</button>
                            </div>

    					 </div>

                        <!-- Loading UI -->
                        <div id="TCPloadingUIHover" style="display: none; width: 400px; padding-top: 30px; padding-bottom: 20px; border-radius: 10px; background-color: #6d909c;">
                            <center>
                                <div class="loader"></div>
                                <br />
                                <label style="color: white;" id="TCPlblUIHover">Sending OTP</label>
                                <br />
                                <label style="color: white;">Please wait...</label>
                                <br />
                            </center>
                        </div>

                    </center>

                

            </div>
        </div>
        <!-- Snackbar -->
        <div id="snackbar"><label id="lblOTPRes"></label></div>



    </div>
    <!-- OTP Modal End -->

                    </center>

                </div>

            </div>
        </div>

    </div>

    <!-- Offers Display Modal End -->

	<div class="loadingUI" id="loadingUI" style="display: none; padding-right: 50px; padding-top: 30px; padding-bottom: 20px; padding-left: 65px; border-radius: 10px; background-color: #6d909c;">
		<!-- <img alt="Loading" src="loading2.gif"> -->
		<div class="loader"></div>
		<br/>
		<label style="color: white;">Please wait...</label>
		<br/>
	</div>
               

               
               
               
               
              <script type="text/javascript">
               
               		var ifMember = document.getElementById('txtMemberNumberTIC').value;
               		var hasTIC = document.getElementById('txtTICPoints').value;
               		
               		if(ifMember == "Member Not Enrolled" || ifMember == "")
               		{
               			
                        //document.getElementById("rdoSelfCard").disabled = true;
                        
                        document.getElementById("btnAvailVoucherShow").disabled = true;
                        document.getElementById("btnOffersShow").disabled = true;
                        
                                

               		}
               		
               		//document.getElementById("btnAvailVoucherShow").style.visibility = "hidden";
               
               </script>
               
<%@ page session="true" %>

<style>
.custom-alert {
    position: fixed;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    background: #ffffff;
    padding: 30px 10px;
    border-radius: 15px;
    box-shadow: 0 8px 25px rgba(0,0,0,0.4);
    z-index: 9999;
    width: 350px; 
    text-align: center;
    font-family: 'Arial', sans-serif;
}

.custom-alert h2 {
    margin: 10px 0;
    font-size: 22px; 
    color: #333;
}

.custom-alert p {
    margin: 8px 0;
    font-size: 18px; 
    color: #555;
}

.custom-alert button {
    margin-top: 20px;
    padding: 10px 25px;
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 8px;
    cursor: pointer;
    font-size: 16px;
    font-weight: bold;
    transition: background-color 0.3s ease;
}

.custom-alert button:hover {
    background-color: #0056b3;
}
</style>

<%
    String outAmount = (String) session.getAttribute("outstandingBalance");
    String cashlisted = (String) session.getAttribute("cashlisted");

    if (outAmount == null || outAmount.trim().isEmpty()) {
        outAmount = "0.0";
    }

    if (cashlisted == null || cashlisted.trim().isEmpty()) {
        cashlisted = "no";
    }

    double balance = 0.0;
    try {
        balance = Double.parseDouble(outAmount);
    } catch (Exception e) {
        balance = 0.0;
    }
%>

<% if (balance > 0) { %>
<div id="alertBox" class="custom-alert" style="display:none;">   
    <% if ("yes".equalsIgnoreCase(cashlisted)) { %>
        <p>CashListed:<%= cashlisted %></p>
    <% } %>
    <p>The Outstanding Balance is: ₹ <%= outAmount %></p>
    <button onclick="closeAlert()">OK</button>
</div>

<script>
window.onload = function() {
    document.getElementById("alertBox").style.display = "block";
};

function closeAlert() {
    document.getElementById("alertBox").style.display = "none";
}
</script>
<% } %>


               
               
               
	
	<%
	
	try
	{
	
		//if the property is not INR, disable the GC option
		String tmpCurrencyCode = HashMapData.mapCurrencyCode.get(request.getParameter("ReservId"));
		
		if(tmpCurrencyCode == null || tmpCurrencyCode == "")
			tmpCurrencyCode = "null";
		
		if(tmpCurrencyCode.equalsIgnoreCase("INR"))
		{
			%>
				<script type="text/javascript">
					
					document.getElementById('rdoPayUsingGiftCard').disabled = false;
					document.getElementById('rdoPayUsingGiftCard').style.visibility = "visible";
					document.getElementById('rdoPayUsingGiftCard').style.display = "inline";
					document.getElementById('lblPayUsingGiftCard').style.visibility = "visible";
					document.getElementById('lblPayUsingGiftCard').style.display = "inline";
				</script>
			<%
			
			
			
		}
		else 
		{
			%>
				<script type="text/javascript">
					document.getElementById('rdoPayUsingGiftCard').disabled = true;
					document.getElementById('rdoPayUsingGiftCard').style.visibility = "hidden";
					document.getElementById('rdoPayUsingGiftCard').style.display = "none";
					document.getElementById('lblPayUsingGiftCard').style.visibility = "hidden";
					document.getElementById('lblPayUsingGiftCard').style.display = "none";
				</script>
			<%
			
			
		}
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	
	try
	{
	
		boolean tmp = Configuration.getGCENabledProperty(request.getParameter("Property"));
		if(tmp)
		{
			%>
				<script type="text/javascript">
					
					document.getElementById('rdoPayUsingGiftCard').style.visibility = "visible";
					document.getElementById('rdoPayUsingGiftCard').style.display = "inline";
					document.getElementById('rdoPayUsingGiftCard').disabled = false;
					document.getElementById('lblPayUsingGiftCard').style.visibility = "visible";
					document.getElementById('lblPayUsingGiftCard').style.display = "inline";
					
				</script>
		<%
		}
		else
		{
			%>
				<script type="text/javascript">
					
					document.getElementById('rdoPayUsingGiftCard').style.visibility = "hidden";
					document.getElementById('rdoPayUsingGiftCard').style.display = "none";
					document.getElementById('rdoPayUsingGiftCard').disabled = true;
					document.getElementById('lblPayUsingGiftCard').style.visibility = "hidden";
					document.getElementById('lblPayUsingGiftCard').style.display = "none";
					
				</script>
		<%
		}
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	
	
	
			
	%>
	
	
	
	
	
	

	

</body>
</html>