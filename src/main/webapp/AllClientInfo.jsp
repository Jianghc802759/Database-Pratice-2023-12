<%@page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>数据库后端界面</title>
    <link rel="stylesheet" type="text/css" href="css/AllClientInfo.css">
    <style>
        body {
            background-image: url("imgs/beijing.jpg");
            background-repeat: no-repeat;
            background-size: cover;
            background-position: center center;
        }
        .modal {
            display: none; /* 默认隐藏模态框 */
            /* 您可以根据需要进行其他样式设置，例如定位、背景色、尺寸等 */
        }

        /* 扩展样式：使模态框居中对齐 */
        .modal-content {
            margin: auto;
            width: 50%;
            border: 1px solid #888;
            padding: 20px;
        }

        .close {
            cursor: pointer;
        }
    </style>
    <script >
        var perPage = 10; //每页显示的项数
        var currentPage = 0; //当前页码开始于0

        window.addEventListener('DOMContentLoaded', (event) => {
            var options = document.querySelectorAll('.sidebar a');

            // 获取之前保存的选项索引
            var selectedOptionIndex = localStorage.getItem('selectedOptionIndex');

            options.forEach(function(option, index) {
                option.addEventListener('click', function() {
                    // 更新选项的活动状态
                    setActiveOption(index);
                });

                // 根据之前保存的选项索引设置活动状态
                if (index.toString() === selectedOptionIndex) {
                    setActiveOption(index);
                }
            });

            function setActiveOption(index) {
                // 移除之前保存的活动状态
                var activeOption = document.querySelector('.sidebar a.active');
                if (activeOption) {
                    activeOption.classList.remove('active');
                }

                // 添加点击选中的选项的活动状态
                options[index].classList.add('active');

                // 保存选项索引到localStorage
                localStorage.setItem('selectedOptionIndex', index.toString());
            }
        });

        function fetchData() {
            fetch('/CarsRental/client/selectAllClient')
                .then(response => response.json())
                .then(data => {
                    clients = data;  // 假设API返回的数据是一个对象数组

                    var tableArea = document.getElementById("clientTable");

                    // 清除在插入新表格之前的任何存在的子元素
                    while (tableArea.firstChild) {
                        tableArea.removeChild(tableArea.firstChild);
                    }

                    var registerForm = createTable();  // 加载新的表格

                    tableArea.appendChild(registerForm);

                    refreshTable();
                })
                .catch(error => console.error('Error:', error));
        }



        function createTable() {
            var table = document.createElement("table");
            var start = currentPage * perPage;
            var end = start + perPage;
            var clientSubset = clients.slice(start, end);
            table.className = "client-table";
            table.id = "clientsTable";

            var thead = document.createElement("thead");
            var headerRow = document.createElement("tr");

            var headers = [
                "clientNo",
                "clientName",
                "clientStreet",
                "clientCity",
                "clientState",
                "clientZipCode",
                "clientTelNo",
                "clientFaxNo",
                "clientWebAddress",
                "contactName",
                "contactTelNo",
                "contactFaxNo",
                "contactEmailAddress",
            ];

            headers.unshift("Select");

            headers.forEach(function(header) {
                var th = document.createElement("th");
                th.textContent = header;
                headerRow.appendChild(th);
            });

            thead.appendChild(headerRow);
            table.appendChild(thead);

            var tbody = document.createElement("tbody");

            clientSubset.forEach(function(client) {
                var row = document.createElement("tr");

                var checkboxCell = document.createElement("td");
                var checkbox = document.createElement("input");
                checkbox.type = "checkbox";
                checkbox.addEventListener('change', function () {
                    client["Select"] = this.checked ? "selected" : "";
                });
                checkboxCell.appendChild(checkbox);

                var dataCells = headers.slice(1).map(function(header) {  // Skip the "Select" header
                    var cell = document.createElement("td");
                    cell.textContent = client[header];  // Use header name to get corresponding value from client
                    return cell;
                });

                dataCells.unshift(checkboxCell);

                dataCells.forEach(function(cell) {
                    row.appendChild(cell);
                });

                tbody.appendChild(row);
            });

            table.appendChild(tbody);

            return table;
        }



        function openAddClientModal() {
            var modal = document.getElementById("addClientModal");
            modal.style.display = "block";
        }

        function closeAddClientModal() {
            var modal = document.getElementById("addClientModal");
            modal.style.display = "none";
        }

        function addClient() {
            var conditions = [
                "clientNo",              // 客户编号
                "clientName",             // 客户名称
                "clientStreet",           // 客户街道
                "clientCity",             // 客户城市
                "clientState",            // 客户州
                "clientZipCode",          // 客户邮政编码
                "clientTelNo",            // 客户电话号码
                "clientFaxNo",            // 客户传真号码
                "clientWebAddress",       // 客户网址
                "contactName",            // 联系人姓名
                "contactTelNo",           // 联系人电话号码
                "contactFaxNo",           // 联系人传真号码
                "contactEmailAddress"    // 联系人电子邮件地址
            ];


            var inputs = document.getElementsByClassName("client-input");
            var client = {};
            for (var i = 0; i < conditions.length; i++) {
                client[conditions[i]] = inputs[i].value;
            }

            fetch('/CarsRental/client/addClient', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(client),
            })
                .then(response => {
                    if (!response.ok) {
                        throw new Error("HTTP error " + response.status);
                    }
                    return response.text().then(function(text) {
                        return text ? JSON.parse(text) : {}
                    })
                })
                .then(data => {
                    if (data.success) {
                        // 提交成功，可以跳转到其他页面或者显示成功信息
                        alert('信息添加成功！');
                        var clientTableDiv = document.getElementById("clientTable");
                        clientTableDiv.innerHTML = "";
                        var clientTable = createTable();
                        clientTableDiv.appendChild(clientTable);
                        refreshTable()
                        location.reload();  // 刷新页面
                    } else {
                        // 提交失败，处理错误信息，例如显示错误提示
                        alert('信息添加失败！');
                        closeAddClientModal();
                    }


                })
                .catch((error) => {
                    console.error('Error:', error);
                });

        }


        var clients = [
            {
                "clientNo": "1",
                "clientName": "Client 1",
                "clientStreet": "Street 1",
                "clientCity": "City 1",
                "clientState": "State 1",
                "clientZipCode": "ZipCode 1",
                "clientTelNo": "TelNo 1",
                "clientFaxNo": "FaxNo 1",
                "clientWebAddress": "WebAddress 1",
                "contactName": "Contact Name 1",
                "contactTelNo": "Contact TelNo 1",
                "contactFaxNo": "Contact FaxNo 1",
                "contactEmailAddress": "Contact Email 1"
            },
            {
                "clientNo": "2",
                "clientName": "Client 2",
                "clientStreet": "Street 2",
                "clientCity": "City 2",
                "clientState": "State 2",
                "clientZipCode": "ZipCode 2",
                "clientTelNo": "TelNo 2",
                "clientFaxNo": "FaxNo 2",
                "clientWebAddress": "WebAddress 2",
                "contactName": "Contact Name 2",
                "contactTelNo": "Contact TelNo 2",
                "contactFaxNo": "Contact FaxNo 2",
                "contactEmailAddress": "Contact Email 2"
            }
        ];



        window.addEventListener('DOMContentLoaded', function() {
            currentPageIndicator = document.getElementById("currentPageIndicator");

            fetchData();  // 这个函数会创建表格并加入到页面中

            updatePageIndicator();
        });


        // 处理行的点击事件，选择行并更新弹窗数据
        function handleRowClick(event) {
            var row = event.target.parentElement;
            selectRow(row);

            if (row.classList.contains("selected")) {
                openEditClientModal(row);
            } else {
                closeEditClientModal();
            }
        }

        // 为表格的每一行添加点击事件监听器
        var tableRows = document.querySelectorAll("#clientTable tbody tr");
        for (var i = 0; i < tableRows.length; i++) {
            tableRows[i].addEventListener("click", handleRowClick);
        }

        // 选中行的处理函数
        function selectRow(row) {
            row.classList.toggle("selected");
        }

        function openEditClientModal() {
            var checkboxes = document.querySelectorAll('.client-table input[type="checkbox"]');
            var selectedRow = null;
            for (var i = 0; i < checkboxes.length; i++) {
                if (checkboxes[i].checked) {
                    selectedRow = checkboxes[i].parentNode.parentNode;
                    break;
                }
            }

            if (selectedRow === null) {
                alert('请先选择一行进行编辑');
                return;
            }

            var modal = document.getElementById("editClientModal");
            modal.style.display = "block";

            // 获取选中行的数据
            var rowData = [];
            var tableCells = selectedRow.getElementsByTagName("td");
            for (var i = 1; i < tableCells.length; i++) { // 从 1 开始，跳过复选框单元格
                rowData.push(tableCells[i].textContent);
            }

            // 在弹窗中填充选中行的数据
            var editForm = document.getElementById("editClientForm");
            var inputFields = editForm.getElementsByClassName("client-input");
            for (var j = 1; j < inputFields.length; j++) {
                inputFields[j].value = rowData[j+1];
            }
            // 在保存数据到编辑模态窗口的时候
            editForm.dataset.clientNo = rowData[0]; // rowData[0] 是当前行的 clientNo

            // 设置当前行的索引作为属性，方便保存时更新相应的表格行
            editForm.setAttribute("data-rowIndex", selectedRow.rowIndex - 1);
        }


        // 关闭弹窗
        function closeEditClientModal() {
            var modal = document.getElementById("editClientModal");
            modal.style.display = "none";
        }

        // 保存修改
        function saveEditedClient() {
            // 从编辑表单中获取数据
            var editForm = document.getElementById("editClientForm");
            var inputFields = editForm.getElementsByClassName("client-input");

            var rowData = [];
            var client = {};

            // 在保存编辑后信息给服务器的时候
            client.clientNo = editForm.dataset.clientNo; // 获取保存在编辑模态窗口内的 clientNo


            for(var i = 1; i < inputFields.length; i++) {
                rowData.push(inputFields[i].value);
            }

            // 我假设每个 "inputFields" 对应的名称 (name) 是和 "conditions" 里的一样
            var conditions = [
                "clientName",           // 客户名称
                "clientStreet",         // 客户街道
                "clientCity",           // 客户城市
                "clientState",          // 客户州
                "clientZipCode",        // 客户邮政编码
                "clientTelNo",          // 客户电话号码
                "clientFaxNo",          // 客户传真号码
                "clientWebAddress",     // 客户网址
                "contactName",          // 联系人姓名
                "contactTelNo",         // 联系人电话号码
                "contactFaxNo",         // 联系人传真号码
                "contactEmailAddress"  // 联系人电子邮件地址
            ];

            for (var i = 0; i < conditions.length; i++) {
                client[conditions[i]] = inputFields[i].value;
            }

            // 假设 'data-rowIndex' 属性保存了惟一的客户ID
            var clientId = editForm.getAttribute('data-rowIndex');

            fetch(`/CarsRental/client/updateClient`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(client),
            })
                .then((response) => response.json())
                .then((data) => {
                    if (data.success) {
                        // 提交成功，可以跳转到其他页面或者显示成功信息
                        alert('信息修改成功！');
                        location.reload();  // 刷新页面
                    } else {
                        // 提交失败，处理错误信息，例如显示错误提示
                        alert('信息修改失败！');
                        closeEditClientModal();
                    }


                })
                .catch((error) => {
                    console.error('Error:', error);
                });
        }


        // 删除信息
        function deleteClients() {
            var checkboxes = document.querySelectorAll('.client-table input[type="checkbox"]');

            // 创建一个数组用于保存所有选择的客户的完整信息
            var clientsToDelete = [];

            checkboxes.forEach((checkbox, index) => {
                if (checkbox.checked) {
                    var row = checkbox.parentNode.parentNode;
                    clientsToDelete.push(row.children[1].textContent);
                }
            });

            // 使用 JSON.stringify 将对象数组转换为 JSON 字符串
            var requestBody = JSON.stringify(clientsToDelete);

            fetch(`/CarsRental/client/deleteClientByIds`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: requestBody,
            })
                .then((response) => response.json())
                .then((data) => {
                    if (data.success) {
                        // 提交成功，可以跳转到其他页面或者显示成功信息
                        alert('信息删除成功！');
                        checkboxes.forEach((checkbox) => {
                            if (checkbox.checked) {
                                checkbox.parentNode.parentNode.remove();
                            }
                        });
                        refreshTable(); // Fetch the most recent data
                        location.reload();  // 刷新页面
                    } else {
                        // 提交失败，处理错误信息，例如显示错误提示
                        alert('信息删除失败！');
                    }

                })
                .catch((error) => {
                    console.error('Error:', error);
                });
        }




        // 在current page变量后面添加一个用于显示当前页面的元素
        var currentPage = 0;
        var currentPageIndicator;

        function updatePageIndicator() {
            // calculate total page count
            var totalPage = Math.ceil(clients.length / perPage);
            currentPageIndicator.innerText = (currentPage + 1) + ' / ' + totalPage;
        }

        function previousPage() {
            if (currentPage > 0) {
                currentPage--;
                refreshTable();
                updatePageIndicator();
            }
        }

        function nextPage() {
            if (currentPage < Math.ceil(clients.length / perPage) - 1) {
                currentPage++;
                refreshTable();
                updatePageIndicator();
            }
        }

        function refreshTable() {
            var oldTable = document.querySelector('table');
            oldTable.parentNode.removeChild(oldTable);

            var table = createTable();
            document.getElementById("clientTable").appendChild(table);
        }









        // 查找
        function search() {
            var clientNo = document.getElementById("searchClientNo").value;
            var clientName = document.getElementById("searchClientName").value;
            var clientStreet = document.getElementById("searchClientStreet").value;
            var clientCity = document.getElementById("searchClientCity").value;
            var clientState = document.getElementById("searchClientState").value;
            var clientZipCode = document.getElementById("searchClientZipCode").value;
            var clientTelNo = document.getElementById("searchClientTelNo").value;
            var clientFaxNo = document.getElementById("searchClientFaxNo").value;
            var clientWebAddress = document.getElementById("searchClientWebAddress").value;
            var contactName = document.getElementById("searchContactName").value;
            var contactTelNo = document.getElementById("searchContactTelNo").value;
            var contactFaxNo = document.getElementById("searchContactFaxNo").value;
            var contactEmailAddress = document.getElementById("searchContactEmailAddress").value;

            var clientsTable = document.getElementById("clientsTable");
            var rows = clientsTable.tBodies[0].rows;

            for (var i = 0; i < rows.length; i++) {
                var row = rows[i];

                // 检查表格行与搜索条件的匹配程度
                var match = row.cells[1].innerHTML.includes(clientNo) &&
                    row.cells[2].innerHTML.includes(clientName) &&
                    row.cells[3].innerHTML.includes(clientStreet) &&
                    row.cells[4].innerHTML.includes(clientCity) &&
                    row.cells[5].innerHTML.includes(clientState) &&
                    row.cells[6].innerHTML.includes(clientZipCode) &&
                    row.cells[7].innerHTML.includes(clientTelNo) &&
                    row.cells[8].innerHTML.includes(clientFaxNo) &&
                    row.cells[9].innerHTML.includes(clientWebAddress) &&
                    row.cells[10].innerHTML.includes(contactName) &&
                    row.cells[11].innerHTML.includes(contactTelNo) &&
                    row.cells[12].innerHTML.includes(contactFaxNo) &&
                    row.cells[13].innerHTML.includes(contactEmailAddress);

                // 根据匹配结果显示/隐藏表格行
                if (match) {
                    row.style.display = ""; // 显示匹配行
                } else {
                    row.style.display = "none"; // 隐藏不匹配行
                }
            }

            // 关闭模态框
            document.getElementById("searchModal").style.display = "none";
        }


        function openModal() {
            document.getElementById('searchModal').style.display = 'block';
        }

        function cancle(){
            var modal = document.getElementById("searchModal");
            modal.style.display = "none";
        }


        // 获取模态框及其组件
        var modal = document.getElementById("myModal");
        var span = document.getElementsByClassName("close")[0];
        var modalData = document.getElementById("modalData");

        // 当用户点击 X 符号或点击（模态框之外的）任何地方，关闭模态框
        span.onclick = function() {
            modal.style.display = "none";
        }
        window.onclick = function(event) {
            if (event.target == modal) {
                modal.style.display = "none";
            }
        }

        function fetchViewData() {
            fetch('https://your-backend.com/view-data', {
                method: 'GET',
            })
                .then(response => response.json())
                .then(data => {

                    // 创建一个表格来存储数据
                    var table = document.createElement('table');

                    // 在数据对象中为每个键值对创建一个表格行
                    for (var key in data) {
                        // 创建一个表格行和两个单元格
                        var row = document.createElement('tr');
                        var cellKey = document.createElement('td');
                        var cellValue = document.createElement('td');

                        // 将键和值放入相应的单元格并将单元格添加到行
                        cellKey.textContent = key;
                        cellValue.textContent = data[key];
                        row.appendChild(cellKey);
                        row.appendChild(cellValue);

                        // 将行添加到表格
                        table.appendChild(row);
                    }

                    // 将表格放入模态框数据区域并显示模态框
                    modalData.textContent = '';       // 清除可能存在的任何旧数据
                    modalData.appendChild(table);
                    modal.style.display = 'block';
                })
                .catch((error) => {
                    console.error('Error:', error);
                });
        }


        // 添加事件监听器，在用户点击视图按钮时调用 fetchViewData 函数
        document.getElementById('viewButton').addEventListener('click', fetchViewData);



    </script>


</head>
<body>
<div class="navbar">
    <!-- 导航栏 -->
    <div class="user-info" onclick="openModal()">
        <img src="imgs/touxiang.webp" alt="头像" />
        <span>树街猫</span>
    </div>
    <!-- 在这里添加其他导航栏项 -->
</div>

<div class="sidebar">
    <!-- 左侧侧边栏选项 -->
    <a href="AllClientInfo.html" class="active">
      <span class="icon">
		  <img src="./imgs/kehu.png" alt="图标1" style="width: 50px;height: 50px;border-radius: 50%;" />
	  </span>
        客户
    </a>
    <a href="AllClientInfo.html">
      <span class="icon">
		  <img src="./imgs/yuangong.png" alt="图标2" style="width: 50px;height: 50px;border-radius: 50%;" />
	  </span>
        员工
    </a>
    <a href="AllFaultReportInfo.html">
      <span class="icon">
		  <img src="./imgs/cuowubaobiao.png" alt="图标3" style="width: 40px;height: 40px;border-radius: 50%;" />
	  </span>
        错误报表
    </a>
    <a href="AllOutletInfo.html">
      <span class="icon">
		  <img src="./imgs/mendian.png" alt="图标4" style="width: 40px;height: 40px;border-radius: 50%;" />
	  </span>
        门店
    </a>
    <a href="AllRentalAgreementInfo.html">
      <span class="icon">
		  <img src="./imgs/zulinxieyi.png" alt="图标5" style="width: 40px;height: 40px;border-radius: 50%;" />
	  </span>
        租赁协议
    </a>
    <a href="AllVehicleInfo.html">
      <span class="icon">
		  <img src="./imgs/cheliang.png" alt="图标6" style="width: 40px;height: 40px;border-radius: 50%;" />
	  </span>
        车辆
    </a>
</div>

<div class="content">
    <div class="a">
        <h2>客户信息</h2>
        <button class="add-client-button" onclick="openAddClientModal()">添加信息</button>
        <button class="edit-client-button" onclick="openEditClientModal()">修改信息</button>
        <button class="delete-client-button" id="deleteButton" onclick="deleteClients()">删除信息</button>
        <button class="open-client-button" id="openModalButton" onclick="openModal()">查询信息</button>
        <button class="view-client-button" id="viewButton">视图窗口</button>
    </div>
    <!-- 添加选项1的相应内容 -->
    <div id="clientTable"></div> <!-- 添加客户的弹窗 -->
    <div id="addClientModal" class="modal">
        <div class="modal-content">
            <h2>添加 信息</h2>

            <label>Client No: <input type="text" id="clientNo" class="client-input" data-key="clientNo"></label><br>
            <label>Client Name: <input type="text" id="clientName" class="client-input" data-key="clientName"></label><br>
            <label>Client Street: <input type="text" id="clientStreet" class="client-input" data-key="clientStreet"></label><br>
            <label>Client City: <input type="text" id="clientCity" class="client-input" data-key="clientCity"></label><br>
            <label>Client State: <input type="text" id="clientState" class="client-input" data-key="clientState"></label><br>
            <label>Client ZipCode: <input type="text" id="clientZipCode" class="client-input" data-key="clientZipCode"></label><br>
            <label>Client TelNo: <input type="text" id="clientTelNo" class="client-input" data-key="clientTelNo"></label><br>
            <label>Client FaxNo: <input type="text" id="clientFaxNo" class="client-input" data-key="clientFaxNo"></label><br>
            <label>Client WebAddress: <input type="text" id="clientWebAddress" class="client-input" data-key="clientWebAddress"></label><br>
            <label>Contact Name: <input type="text" id="contactName" class="client-input" data-key="contactName"></label><br>
            <label>Contact TelNo: <input type="text" id="contactTelNo" class="client-input" data-key="contactTelNo"></label><br>
            <label>Contact FaxNo: <input type="text" id="contactFaxNo" class="client-input" data-key="contactFaxNo"></label><br>
            <label>Contact Email Address: <input type="text" id="contactEmail" class="client-input" data-key="contactEmailAddress"></label><br>

            <button class="add-client-button" onclick="addClient()">add</button>
            <button class="add-client-button" onclick="closeAddClientModal()">cancle</button>


        </div>
    </div>
</div>

<div id="editClientModal" class="modal">
    <div class="modal-content">
        <h2>修改 信息</h2>
        <form id="editClientForm" data-rowIndex="">
            <label for="editClientName">Client Name:</label> <input type="text" id="editClientName" class="client-input" data-key="clientName"><br>
            <label for="editClientStreet">Client Street:</label> <input type="text" id="editClientStreet" class="client-input" data-key="clientStreet"><br>
            <label for="editClientCity">Client City:</label> <input type="text" id="editClientCity" class="client-input" data-key="clientCity"><br>
            <label for="editClientState">Client State:</label> <input type="text" id="editClientState" class="client-input" data-key="clientState"><br>
            <label for="editClientZipCode">Client ZipCode:</label> <input type="text" id="editClientZipCode" class="client-input" data-key="clientZipCode"><br>
            <label for="editClientTelNo">Client TelNo:</label> <input type="text" id="editClientTelNo" class="client-input" data-key="clientTelNo"><br>
            <label for="editClientFaxNo">Client FaxNo:</label> <input type="text" id="editClientFaxNo" class="client-input" data-key="clientFaxNo"><br>
            <label for="editClientWebAddress">Client WebAddress:</label> <input type="text" id="editClientWebAddress" class="client-input" data-key="clientWebAddress"><br>
            <label for="editContactName">Contact Name:</label> <input type="text" id="editContactName" class="client-input" data-key="contactName"><br>
            <label for="editContactTelNo">Contact TelNo:</label> <input type="text" id="editContactTelNo" class="client-input" data-key="contactTelNo"><br>
            <label for="editContactFaxNo">Contact FaxNo:</label> <input type="text" id="editContactFaxNo" class="client-input" data-key="contactFaxNo"><br>
            <label for="editContactEmail">Contact Email Address:</label> <input type="text" id="editContactEmail" class="client-input" data-key="contactEmailAddress"><br>


            <button class="edit-client-button" type="button" onclick="saveEditedClient()">Save</button>
            <button class="edit-client-button" type="button" onclick="closeEditClientModal()">Cancel</button>
        </form>
    </div>
</div>

<div class="bottom-button" style="position:fixed;bottom:0;width:100%;display:flex;justify-content:center;color:#f8f8f8;">
    <span id="currentPageIndicator" style="position: absolute;bottom: 0; left: 200px; font-size: 20px; color:#000000;"></span>
    <button onclick="previousPage()" style="margin-right:20px;padding:10px 20px;cursor:pointer;color:#fff;background:#007BFF;border:none;border-radius:5px;font-size:15px;">上一页</button>
    <button onclick="nextPage()" style="padding:10px 20px;cursor:pointer;color:#fff;background:#007BFF;border:none;border-radius:5px;font-size:15px;">下一页</button>
</div>


<div id="searchModal" class="modal">
    <div class="modal-content">
        <p>请输入要查找的信息：</p>
        Client No: <input type="text" id="searchClientNo"><br>
        Client Name: <input type="text" id="searchClientName"><br>
        Client Street: <input type="text" id="searchClientStreet"><br>
        Client City: <input type="text" id="searchClientCity"><br>
        Client State: <input type="text" id="searchClientState"><br>
        Client ZipCode: <input type="text" id="searchClientZipCode"><br>
        Client TelNo: <input type="text" id="searchClientTelNo"><br>
        Client FaxNo: <input type="text" id="searchClientFaxNo"><br>
        Client WebAddress: <input type="text" id="searchClientWebAddress"><br>
        Contact Name: <input type="text" id="searchContactName"><br>
        Contact TelNo: <input type="text" id="searchContactTelNo"><br>
        Contact FaxNo: <input type="text" id="searchContactFaxNo"><br>
        Contact Email Address: <input type="text" id="searchContactEmailAddress"><br>
        <button onclick="search()">查找</button>
        <button onclick="cancle()">取消</button>
    </div>
</div>

<div id="searchResults"></div>

<!-- 模态框结构 -->
<div id="myModal" class="modal">
    <!-- 模态框内容 -->
    <div class="modal-content">
        <span class="close">&times;</span>
        <p id="modalData">No data</p>  <!-- 这里是我们将显示数据的地方 -->
    </div>
</div>


</body>
</html>

