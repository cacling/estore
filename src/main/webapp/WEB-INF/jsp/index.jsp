<%@ include file="../../common/common-jsp-header.jsp"%>
<html>
<head>
	<link rel="stylesheet" href="css/home.css" type="text/css" media="screen" charset="utf-8" />
	<script type="text/javascript" src="js/dojo.js"></script>
    <script type="text/javascript" src="js/login.js">
        function pickDate() {
        }
    </script>
    
    <style type="text/css">

	
    </style>
</head>
<body>
	<div id="shortcut">
		<div class="menu"> 
			<div class="fr">
				<div class="item" id="nologinDiv"><a href="#" onclick="showLoginWindow();">Login</a></div>
				<div class="item" id="loginedDiv">Hi, <span id="sayHiTo">${username}</span><a href="#" onclick="doLogout()" style="margin-left: 10px">[Logout]</a></div>
				<input type="hidden" id="loginedUsername" value="${username}">
				<div class="split">|</div>
				<div class="item"><a href="#">My Orders</a></div><div class="split">|</div>
				<div class="item"><a href="#">Help</a> </div><div class="split">|</div>
			</div>
		</div>
	</div>
	<div id="container">
		<div id="header">
			<div id="search">
		        <div class="box-outer">
					<div class="box-inner">
						<input type="text" onkeydown="javascript:if(event.keyCode==13) search('key');" autocomplete="off" id="key" accesskey="s" class="text">
		          		<input type="button" onclick="search('key');return false;" class="button" value="Go">
		        	</div>
		        </div>
		    </div>
		    <div id="checkout">
		    	<div class="items">1 items</div>
		    	<div class="total">$ 0.00</div>
		    	<div class="go"><a href="#"></a></div>
		    </div>
	    </div>
	    
	    <div id="displayArea">
	    
	    
	    <div id="bestSellingProducts">
	    	<div class="title">
	    		Best Selling Products
	    	</div>
	    	<div class="items">
		    	<c:forEach items="${bestSellingProducts}" var="bestSellingProduct">
					<div class="item">
						<div class="image">
							<img alt="" src="i/sample/${bestSellingProduct.image}" width="130px" height="130px">
						</div>
						<div class="itemname">
							${bestSellingProduct.name} 
						</div>
						<div class="itemprice">
							$ ${bestSellingProduct.salePrice} (${bestSellingProduct.discount} off)
						</div>
						<div class="itemToCart">
							<img alt="" src="i/addToCart.jpg">
						</div>
					</div>
				</c:forEach>
			</div>
	    </div>
	    
	    <div id="bestPriceProducts">
	    	<div class="title">
	    		Best Price Products
	    	</div>
	    	<div class="items">
		    	<c:forEach items="${bestPriceProducts}" var="bestPriceProduct">
					<div class="item">
						<div class="image">
							<img alt="" src="i/sample/${bestPriceProduct.image}" width="130px" height="130px">
						</div>
						<div class="itemname">
							${bestPriceProduct.name} 
						</div>
						<div class="itemprice">
							$ ${bestPriceProduct.salePrice} (${bestPriceProduct.discount} off)
						</div>
						<div class="itemToCart">
							<img alt="" src="i/addToCart.jpg">
						</div>
					</div>
				</c:forEach>
			</div>
	    </div>
	    
	    <div id="newProducts">
	    	<div class="title">
	    		New Products
	    	</div>
	    	<div class="items">
		    	<c:forEach items="${newProducts}" var="newProduct">
					<div class="item">
						<div class="image">
							<img alt="" src="i/sample/${newProduct.image}" width="130px" height="130px">
						</div>
						<div class="itemname">
							${newProduct.name} 
						</div>
						<div class="itemprice">
							$ ${newProduct.salePrice} (${newProduct.discount} off)
						</div>
						<div class="itemToCart">
							<img alt="" src="i/addToCart.jpg">
						</div>
					</div>
				</c:forEach>
			</div>
	    </div>
	    
	    </div>
	    
	    <div id="recommendArea">
	    	<div class="title">Recommendations</div>
	    	<div class="items">
		    	<c:forEach items="${recommendProducts}" var="recommendProduct">
					<div class="item">
						<div class="image">
							<img alt="" src="i/sample/${recommendProduct.image}" width="55px" >
						</div>
						<div class="itemname">
							${recommendProduct.name} 
						</div>
						<div class="itemprice">
							$ ${recommendProduct.salePrice} (${recommendProduct.discount} off)
						</div>
					</div>
				</c:forEach>
			</div>
	    	
	    </div>
	    

		<div id="footer">
			<div class="item" style="margin-left: 250px">
				<a href="#">Contact us</a>
			</div>
			<div class="item">
				<a href="#">Conditions of Use</a>
			</div>
			<div class="item">
				<a href="#">Privacy Notice</a>
			</div>
		</div>
	</div>
	
	<div id="loginDiv">
		<form id="loginForm" action="login.json">
			<div class="title">
				<div class="fr"></div>
				<div class="fr close" onclick="closeLoginWindow();"><img src="i/icon-close.gif" /></div>
			</div>
			<div class="item">
				<div class="label">Username: </div><div class="fl"><input type="text" class="text" id="loginUsername" name="username" /></div>
			</div>
			<div class="item">
				<div class="label">Password: </div><div class="fl"><input type="password" class="text password" id="loginPassword" name="password" /></div>
				<div id="loginErrorDiv"><div class="label"></div><div id="loginErrorMsg" class="fl error-message"></div></div> 
			</div>
			<div class="item">
				<div class="label">&nbsp;</div><div class="fl"><input type="button" id="loginBtn" class="btn" value="Login" onclick="doLogin()"></div>
			</div>
		</form>
	</div>
</body>
</html>

 