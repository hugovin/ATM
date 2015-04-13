<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>ATM | Home</title>
<link href="<c:url value='/resources/css/bootstrap.min.css' />"
	rel="stylesheet" type="text/css" />
	<link href="<c:url value='/resources/css/gsdk-base.css' />"
	rel="stylesheet" type="text/css" /> 
	
</head>
<body>
	<div class="image-container set-full-height">

    
    <!--   Big container   -->
    <div class="container">
        <div class="row">
        <div class="col-sm-8 col-sm-offset-2">
           
            <!--      Wizard container        -->   
            <div class="wizard-container"> 
                <form action="" method="">
                <div class="card wizard-card ct-wizard-orange" id="wizard">
                
       
                
                    	<div class="wizard-header">
                        	<h3>
                        	   <b>ATM </b> Test <br>
                        	   <small>This test will only allow you to withdraw money.</small>
                        	</h3>
                    	</div>
                    	<ul>
                            <li><a href="#operation" data-toggle="tab">Operation</a></li>
                            <li><a href="#amount" data-toggle="tab">Amount</a></li>
                   
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane" id="operation">
                              <div class="row">
                                  <h4 class="info-text"> What you want to do?</h4>
                                  <div class="col-sm-4 col-sm-offset-1">
                                     
                                  </div>
                                  <div class="col-sm-6">
                                      <div class="form-group">
                                         <label>
   										   <input type="radio" name="optionsRadios" id="optionsRadios3" value="option3" checked disabled>
    										Withdraw
  										</label>
                                      </div>
                                      
                                      
                                  </div>
                              </div>
                            </div>
                            <div class="tab-pane" id="amount">
                                <h4 class="info-text"> How much money do you want? </h4>
                                <div class="row">
          
                                    <div class="col-sm-10 col-sm-offset-1">
                                         <div class="form-group">
                                            <labe>Amount</label>
                                            <input data-bind="value : amount" type="number" maxlength="5" class="form-control" placeholder="00000">
                                          </div>
                                    </div>
                                   <div class="col-sm-10 col-sm-offset-1">
                                          <div class="bs-callout bs-callout-info" id="callout-helper-bg-specificity">
  											  <h4 id="dealing-with-specificity">Denomination currency notes<a class="anchorjs-link" href="#dealing-with-specificity"><span class="anchorjs-icon"></span></a></h4>
    										  <p class="text-info"> 20000 Colones | 10000 Colones | 5000 Colones | 2000 Colones</p>
                                          </div>
                                    </div>
                                </div>
                            </div>
                            
                        </div>
                        <div class="wizard-footer">
                            	<div class="pull-right">
                                    <input type='button' class='btn btn-next btn-fill btn-warning btn-wd btn-sm' name='next' value='Next' />
                                    <input type='button' data-bind="click : doWithdraw" class='btn btn-finish btn-fill btn-warning btn-wd btn-sm' name='finish' value='Finish' />
        
                                </div>
                                <div class="pull-left">
                                    <input type='button' class='btn btn-previous btn-fill btn-default btn-wd btn-sm' name='previous' value='Previous' />
                                </div>
                                <div class="clearfix"></div>
                        </div>	
                </div>
                </form>
            </div> <!-- wizard container -->
        </div>
        </div><!-- end row -->
    </div> <!--  big container -->
    
    
     <div class="footer">
    </div>
    


</div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" id="modalBody">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel" data-bind="text: title"></h4>
      </div>
      <div class="modal-body" >
        <h3 data-bind="text: message"></h3>
        <ul class="list-unstyled" data-bind="foreach: listOfBills">
          <li><span class="data-value" data-bind="text: $data"></span></li>
         
        </ul>
        <div id="spinnerDiv"></div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

	<!-- Scripts -->
	<script src="<c:url value ="/resources/js/knockout-3.3.0.js" />"
		type="text/javascript"></script>
	
	<script src="<c:url value ="resources/js/jquery-1.10.2.js"/>"
		type="text/javascript"></script>
		<script src="<c:url value ="resources/js/bootstrap.js"/>"
		type="text/javascript"></script>
     <script src="<c:url value ="resources/js/jquery.bootstrap.wizard.js"/>"
		type="text/javascript"></script>
	<script src="<c:url value ="resources/js/wizard.js"/>"
		type="text/javascript"></script>
	<script src="<c:url value ="/resources/js/knockout.validation.min.js" />"
		type="text/javascript"></script>
	<script src="<c:url value ="/resources/js/spin.js" />"
		type="text/javascript"></script>		
	<script src="<c:url value ="resources/js/home.js"/>"
		type="text/javascript"></script>
</body>
</html>
