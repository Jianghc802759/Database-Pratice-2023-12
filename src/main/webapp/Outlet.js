document.addEventListener("DOMContentLoaded", function () {
    var outletForm = document.getElementById('outletForm');
    var outletInfoContainer = document.getElementById('outletInfo');

    outletForm.addEventListener('submit', function (event) {
        event.preventDefault();
        submitOutletForm();
    });
});

function submitOutletForm() {
    var outletStreet = document.getElementById('outletStreet').value;
    var outletCity = document.getElementById('outletCity').value;
    var outletState = document.getElementById('outletState').value;

    var apiUrl = '/CarsRental/outlet/selectoutletByCondition' +
        '?outletStreet=' + encodeURIComponent(outletStreet) +
        '&outletCity=' + encodeURIComponent(outletCity) +
        '&outletState=' + encodeURIComponent(outletState);

    var outletInfo = [];
    var outletInfoHTML = '';
	// var data = [{
	// 	"managerEmployeeNo":"E1567956853",
	// 	"outletCity":"city1",
	// 	"outletFaxNo":"456001",
	// 	"outletNo":1,
	// 	"outletState":"state1",
	// 	"outletStreet":"street1",
	// 	"outletTelNo":"123001",
	// 	"outletZipCode":"000001"}];

    fetch(apiUrl)
        .then(response => response.json())
        .then(data => {
            for (let i = 0; i < data.length; i++) {
                outletInfo.push(data[i]);
            }

            for (let i = 0; i < outletInfo.length; i++) {
                outletInfoHTML += '<p>门店编号：' + outletInfo[i].outletNo + '</p>';
                outletInfoHTML += '<p>门店街道：' + outletInfo[i].outletStreet + '</p>';
                outletInfoHTML += '<p>门店城市：' + outletInfo[i].outletCity + '</p>';
                outletInfoHTML += '<p>门店州：' + outletInfo[i].outletState + '</p>';
                outletInfoHTML += '<p>门店邮政编码：' + outletInfo[i].outletZipCode + '</p>';
                outletInfoHTML += '<p>门店电话号码：' + outletInfo[i].outletTelNo + '</p>';
                outletInfoHTML += '<p>门店传真号码：' + outletInfo[i].outletFaxNo + '</p>';
                console.log(outletInfo[i].outletNo);
            }

            var outletInfoContainer = document.getElementById('outletInfo');
            outletInfoContainer.innerHTML = outletInfoHTML;
        })
        .catch(error => {
            console.error('Error fetching outlet information:', error);
            outletInfoContainer.innerHTML = '<p>未找到相关门店信息。</p>';
        });
}
