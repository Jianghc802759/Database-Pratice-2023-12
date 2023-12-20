// Outlet.js

document.addEventListener("DOMContentLoaded", function () {
    // 处理门店信息查询表单提交事件
    var outletForm = document.getElementById('outletForm');
    var outletInfoContainer = document.getElementById('outletInfo');

    outletForm.addEventListener('submit', function (event) {
        event.preventDefault(); // 阻止表单提交的默认行为
        submitOutletForm();
    });
});

function submitOutletForm() {
    // 获取用户输入的门店信息
    var outletStreet = document.getElementById('outletStreet').value;
    var outletCity = document.getElementById('outletCity').value;
    var outletState = document.getElementById('outletState').value;

    // 构造请求的 URL，这里使用了简单的查询参数拼接方式，实际应该根据后端 API 的要求来构造
    var apiUrl = '/CarsRental/outlet/selectoutletByCondition' +
        '?outletStreet=' + encodeURIComponent(outletStreet) +
        '&outletCity=' + encodeURIComponent(outletCity) +
        '&outletState=' + encodeURIComponent(outletState);
	var outletInfo = [];
    // 发送请求到后端
    fetch(apiUrl)
        .then(response => response.json())
        .then(data => {
			outletInfo = data;
        })
        .catch(error => {
            console.error('Error fetching outlet information:', error);
            // 在实际应用中，可以显示错误信息给用户
            outletInfoContainer.innerHTML = '<p>未找到相关门店信息。</p>';
        });
	 var outletInfoHTML = '<h3>门店信息</h3>';
	 console.log(outletInfo);
	 console.log(outletInfo[0].outletCity);
        // 处理返回的门店信息，这里简单地将信息显示在页面上
     outletInfoHTML += '<p>门店编号：' + outletInfo[0].outletNo + '</p>';
     outletInfoHTML += '<p>门店街道：' + outletInfo[0].outletStreet+ '</p>';
     outletInfoHTML += '<p>门店城市：' + outletInfo[0].outletCity + '</p>';
     outletInfoHTML += '<p>门店州：' + outletInfo[0].outletState + '</p>';
     outletInfoHTML += '<p>门店邮政编码：' + outletInfo[0].outletZipCode + '</p>';
     outletInfoHTML += '<p>门店电话号码：' + outletInfo[0].outletTelNo + '</p>';
     outletInfoHTML += '<p>门店传真号码：' +outletInfo[0].outletFaxNo + '</p>';
	 console.log(outletInfo['outletNo']);
     // 显示门店信息
	var outletInfoContainer = document.getElementById('outletInfo');
    outletInfoContainer.innerHTML = outletInfoHTML;
}
