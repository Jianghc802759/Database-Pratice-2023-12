document.addEventListener("DOMContentLoaded", function () {
    // 模拟异步加载汽车卡片数据
    setTimeout(function () {
        const carContainer = document.getElementById('carContainer');

        // 模拟汽车数据
        const cars = [
            { model: '1.4T自动 | 三厢五座', price: '$40/day', image: 'image/car1.png' },
            { model: '高端车型 | 舒适大气', price: '$65/day', image: 'image/car2.png' },
            { model: '中高端车型 | 安全首选', price: '$50/day', image: 'image/car3.png' },
            { model: '商务用车 | 出差办公',price: '$65/day', image: 'image/car4.png' }
            // 添加更多汽车数据
        ];

        // 动态创建汽车卡片
        cars.forEach(car => {
            const carCard = document.createElement('div');
            carCard.classList.add('car-card');

            const carImage = document.createElement('img');
            carImage.src = car.image;
            carImage.alt = car.model;

            const carTitle = document.createElement('h3');
            carTitle.textContent = car.model;

            const carPrice = document.createElement('p');
            carPrice.textContent = `价格: ${car.price}`;

            const rentButton = document.createElement('button');
            rentButton.textContent = '租赁';

            // 将元素添加到汽车卡片中
            carCard.appendChild(carImage);
            carCard.appendChild(carTitle);
            carCard.appendChild(carPrice);
            carCard.appendChild(rentButton);

            // 将汽车卡片添加到容器中
            carContainer.appendChild(carCard);
        });
    }, 1000); // 模拟1秒延迟加载
});
// index.js

document.addEventListener("DOMContentLoaded", function () {
    // 其他首页的初始化逻辑

    // 处理导航栏点击事件
    var navButtons = document.querySelectorAll('.nav-button');
    navButtons.forEach(function (button) {
        button.addEventListener('click', function () {
            // 获取点击按钮的文本内容
            var buttonText = button.textContent.trim();

            // 根据按钮内容进行跳转逻辑
            switch (buttonText) {
                case '首页':
                    // 当前页面就是首页，无需跳转
                    break;
                case '门店':
                    window.location.href = 'SelectOutlet.html'; // 替换为门店页面的 URL
                    break;
                case '车辆信息':
                    window.location.href = 'Vehicles.html'; // 替换为车辆信息页面的 URL
                    break;
                case '个人中心':
                    window.location.href = 'profile.html'; // 替换为个人中心页面的 URL
                    break;
                default:
                    break;
            }
        });
    });
});
