var show = {
        URL: {
            show: function () {
                return 'channel/list/';
            }
        },
        listChannel: {
            execute: function (category) {
                var url = show.URL.show() + category;
                console.log(url);
                $('#dLoading').show();
                $('#dChannel').hide();
                $.get(url, {}, function (response) {
                    var dataList = response.dataList;
                    if(dataList == null || dataList.length <= 0){
                        //TODO show no data
                        return
                    }
                    $('#dChannel').empty();
                    $('#dLoading').hide();
                    $(dataList).each(function (k, v) {
                        var channel = '<a class="col-lg-2 col-6" style="margin-top: 5px" name="channel" url="' + v['url'] + '">\n' +
                            ' <div>\n' +
                            '    <div class="card">\n' +
                            '        <img class="card-img-top" src="'+ v['icon'] + '"\n' +
                            '             onerror="this.src=\'Resource/img/bvision_holder.jpg\'">\n' +
                            '        <div class="text-center" style="padding: 5px 0">\n' +
                            '             <span class="card-title">' + v['name'] + '</span>\n' +
                            '        </div>\n' +
                            '     </div>\n' +
                            ' </div>\n' +
                            '</a>';
                        $( '#dChannel' ).append(channel);
                    });

                    $('a[name=channel]').click(function () {
                        var url = $(this).attr('url');
                        console.log(url);
                        window.webkit.messageHandlers.AppModel.postMessage(url);
                    });
                    $('#dChannel').show();
                })
            }
        }


    };

