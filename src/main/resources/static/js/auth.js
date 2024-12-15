document.addEventListener('DOMContentLoaded', function() {
    // Переключение между вкладками
    const tabButtons = document.querySelectorAll('.tab-btn');
    const forms = document.querySelectorAll('.auth-form');

    tabButtons.forEach(button => {
        button.addEventListener('click', () => {
            // Удаляем активный класс у всех кнопок и форм
            tabButtons.forEach(btn => btn.classList.remove('active'));
            forms.forEach(form => form.classList.remove('active'));

            // Добавляем активный класс нужной кнопке и форме
            button.classList.add('active');
            const formClass = button.getAttribute('data-tab') + '-form';
            document.querySelector('.' + formClass).classList.add('active');
        });
    });

    // Показать/скрыть пароль
    const toggleButtons = document.querySelectorAll('.toggle-password');
    
    toggleButtons.forEach(button => {
        button.addEventListener('click', () => {
            const input = button.parentElement.querySelector('input');
            const type = input.getAttribute('type');
            
            if (type === 'password') {
                input.setAttribute('type', 'text');
                button.querySelector('img').style.opacity = '0.8';
            } else {
                input.setAttribute('type', 'password');
                button.querySelector('img').style.opacity = '0.5';
            }
        });
    });

    // Обработка отправки форм
    const loginForm = document.querySelector('.login-form');
    const registerForm = document.querySelector('.register-form');

    loginForm.addEventListener('submit', function(e) {
        e.preventDefault();
        // Здесь будет логика входа
        console.log('Login submit');
    });

    registerForm.addEventListener('submit', function(e) {
        e.preventDefault();
        // Здесь будет логика регистрации
        console.log('Register submit');
    });
});
