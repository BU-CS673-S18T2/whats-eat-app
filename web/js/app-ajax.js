$(document).ready(function(){
    var slider = document.getElementById("myRange1");
    var output = document.getElementById("output");
    output.innerHTML = slider.value;

    slider.oninput = function() {
        output.innerHTML = this.value;
    };

    $(".signupbtn").click(function() {
        var $username = $('[name="username"]');
        var $email = $('[name="email"]');
        var $password = $('[name="password"]');
        var $psw_repeat = $('[name="psw-repeat"]');
        var $gender = $('[name="gender"]');
        var $height = $('[name="height"]');
        var $weight = $('[name="weight"]');
        var $age = $('[name="age"]');

        var user = {
            username: $username.val(),
            email: $email.val(),
            password: $password.val(),
            psw_repeat: $psw_repeat.val(),
            gender: $gender.val(),
            height: $height.val(),
            weight: $weight.val(),
            age: $age.val()
        };

        filter = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
        console.log(user.email);
        if (!filter.test(user.email)) {
            alert('Invalid Email Address');
        } else if (user.password.length < 6) {
            alert('Password must be longer than 6');
        } else if (user.password != user.psw_repeat) {
            alert('Password does not match!');
        } else {
            $.ajax({
                type: 'POST',
                url: 'api/main/signup',
                data: user,
                success: function(newUser){
                    $("#signupform")[0].reset();
                    $("#id01").hide();
                    $("#signup").hide();
                    $("#login").hide();
                    var welcome = "Welcome, " + newUser.username + "!";
                    $("#welcome")[0].innerHTML = welcome;
                },
                error: function () {
                    alert("error");
                }
            })
        }


    });

    $(".loginbtn").click(function(){
        var $username = $('[name="loginname"]');
        var $password = $('[name="loginpassword"]');

        var user = {
            username: $username.val(),
            password: $password.val()
        };


        $.ajax({
            type: 'POST',
            url: 'api/main/signin',
            data: user,
            success: function(newUser){
                $("#loginform")[0].reset();
                $("#id02").hide();
                $("#signup").hide();
                $("#login").hide();
                var welcome = "Welcome, " + newUser.username + "!";
                $("#logout")[0].innerHTML = "logout";
                $("#welcome")[0].innerHTML = welcome;

            },
            error: function () {
                alert("error");
            }
        })

    });
    var foods;
    $(".Button").click(function(){

        $.ajax({
            type: 'GET',
            url: 'api/main/food/calorie/'+slider.value,
            success: function (foodlist) {
                console.log(slider.value, 'api/main/food/calorie/'+slider.value);
                foods = foodlist;
                var rdn = Math.floor((Math.random() * foodlist.length) + 1);
                var html = foods[rdn].name+
                    ", Calories: "+ foods[rdn].calorie;
                var name = rdn+1+"";
                while(name.length <5) name = "0" + name;
                var src = "/resource/food_image/img"+ name + ".jpg";
                document.getElementById("demo").innerHTML = html;
                $("#food_pic").attr('src', src)
            }
        })

    });
});


