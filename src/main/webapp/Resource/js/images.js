$(function () {

    $('#btn-add').click(function () {
        console.log("sdf");
        window.open('/liveplay/images/up/?id=0', '_self')
    });

   var delete_url = location.href + 'delete';
   $('.delete').each(function () {
       $(this).click(function () {
           var id = $(this).prev().val();
           var li = $(this).parents('li').first();
           $.ajax({
               url: delete_url,
               method: 'POST',
               data: {id: id},
               dataType: 'json',
               beforeSend: function () {
                  $('#progress_div').css('display', 'block')
               },
               success: function (response) {
                  showSuccessMessage(response.message);
                  if(response.code === 200) {
                      li.css('display', 'none');
                  }
               },
               error: function () {
                  showErrorMessage()
               }
           });
       })
   });

});