(function ($) {
    function Carousel1__onTranslated() {
        $(".packages-carousel").trigger('play.owl.autoplay');
        
        $(".packages-carousel").attr('data-packages-carousel-autoplay-status', 'Y');
    }
    "use strict";
    $(".packages-carousel").owlCarousel({
        autoplay: true,
        autoplayTimeout:2000,        
        center: false,
        dots: false,
        loop: true,
        margin: 25,
        nav : true,
        navText : [
            '<i class="bi bi-arrow-left"></i>',
            '<i class="bi bi-arrow-right"></i>'
        ],
        responsiveClass: true,        
        responsive: {
            items:3,
            autoplayHoverPause:false,
            onTranslated: Carousel1__onTranslated,
        }
    });
 
    $('#carouselplaybtn').on('click',function(){
        $(".packages-carousel").trigger('play.owl.autoplay');
    
        $(".packages-carousel").attr('data-packages-carousel-autoplay-status', 'Y');
        alert("스와이프가 실행되었습니다.");
        $("#carouselstopbtn").css("display","");
        $("#carouselplaybtn").css("display","none");
    });

    $('#carouselstopbtn').on('click',function(){
        $(".packages-carousel").trigger('stop.owl.autoplay');
    
        $(".packages-carousel").attr('data-packages-carousel-autoplay-status', 'N');
        alert("스와이프가 중지되었습니다.");
        $("#carouselplaybtn").css("display","");
        $("#carouselstopbtn").css("display","none");
    });
})(jQuery);
