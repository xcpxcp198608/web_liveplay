/**
 * common JavaScript code
 * Created by patrick on 24/08/2017.
 */

/**************************************************** Sort function ***************************************************/

/**
 * sort function for number array
 * @param n
 * @param m
 * @returns {number}
 */
function sortNumber(n , m) {
    return n - m;
}

/*********************************************** For browser compatible ***********************************************/

/**
 * get style in css (not defined in tag)
 * @param obj object
 * @param style target style name
 * @returns {*}
 */
function getStyle(obj, style) {
    if(obj.currentStyle){
        // IE
        return obj.currentStyle[style]
    }else{
        //FF, Chrome
        return getComputedStyle(obj,false)[style]
    }
}

/**
 * get first child node (compatible)
 * @param obj
 * @returns {*}
 */
function getFirstChild(obj) {
    if(obj.firstElementChild){
        //for Chrome,FF
        return obj.firstElementChild;
    }else{
        //fro IE6-8
        return obj.firstChild
    }
}

/**
 * get last child node (compatible)
 * @param obj
 * @returns {*}
 */
function getLastChild(obj) {
    if(obj.lastElementChild){
        //for Chrome,FF
        return obj.lastElementChild;
    }else{
        //fro IE6-8
        return obj.lastChild
    }
}

/**
 * get previous node (compatible)
 * @param obj
 * @returns {*}
 */
function getPreviousNode(obj) {
    if(obj.previousElementSibling){
        //for Chrome,FF
        return obj.previousElementSibling;
    }else{
        //fro IE6-8
        return obj.previousSibling
    }
}

/**
 * get next node (compatible)
 * @param obj
 * @returns {*}
 */
function getNextNode(obj) {
    if(obj.nextElementSibling){
        //for Chrome,FF
        return obj.nextElementSibling;
    }else{
        //fro IE6-8
        return obj.nextSibling
    }
}

/**
 * get event object
 * @param eve  for FF and Chrome
 * @returns {*|Event}
 */
function getEvent(eve) {
    return eve||event;
}

/**
 * get current mouse position
 * @param eve  event object
 * @returns {{x: number, y: number}}
 */
function getMousePosition(eve) {
    var scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
    var scrollLeft = document.documentElement.scrollLeft || document.body.scrollLeft;
    return {x: eve.clientX + scrollLeft, y: eve.clientY + scrollTop};
}

/**
 * binding event for element object
 * @param obj        element object
 * @param event      event name without on
 * @param fun        target binding function
 */
function bindingEvent(obj, event, fun) {
    if(obj.attachEvent){
        obj.attachEvent("on"+event, fun)
    }else{
        obj.addEventListener(event, fun, false)
    }
}

/**
 *  unbinding event for element object
 *  can not work when binding anonymous function on element object
 * @param obj        element object
 * @param event      event name without on
 * @param fun        target binding function
 */
function unbindingEvent(obj, event, fun) {
    if(obj.detachEvent){
        obj.detachEvent("on"+event, fun)
    }else{
        obj.removeEventListener(event, fun, false)
    }
}

/**
 * prevent window default event
 * @param eve
 */
function preventDefault(eve) {
    var ev = eve || window.event;
    if(ev.preventDefault){
        ev.preventDefault();
    }else{
        ev.returnValue = false;
    }
}

/**
 * get current display area scroll top distance
 * @returns {number}
 */
function getScrollTop() {
    return document.body.scrollTop || document.documentElement.scrollTop
}

/**
 * get xmlDom from load xml file
 * @param xmlFile
 * @param completeFun
 * @returns {*}
 */
function getXmlDomFromFile(xmlFile, completeFun){
    var xmlDom = null;
    if (window.ActiveXObject){
        xmlDom = new ActiveXObject("Microsoft.XMLDOM");
        xmlDom.onreadystatechange = function () {
            if(xmlDom.readyState === 4){
                completeFun(xmlDom);
            }
        };
        xmlDom.load(xmlFile);
    }else {
        var xmlHttp = new window.XMLHttpRequest();
        xmlHttp.open("GET", xmlFile, true);
        xmlHttp.onreadystatechange = function () {
            if(xmlHttp.readyState === 4){
                completeFun(xmlHttp.responseXML);
            }
        };
        xmlHttp.send(null);
        xmlDom = xmlHttp.responseXML;
    }
    return xmlDom;
}

/******************************** get element array by class name under special target ********************************/

/**
 * get element object array by class name from special obj
 * @param obj          element object
 * @param className    target class name
 * @returns {Array}    element array
 */
function getElementsByClass(obj, className) {
    var elements = obj.getElementsByTagName("*");
    var resultArray = [] ;
    for(var i = 0 ; i < elements.length ; i ++){
        if(elements[i].className === className){
            resultArray.push(elements[i]);
        }
    }
    return resultArray;
}

/********************************************** change style framework ************************************************/

/**
 * change 'width', 'height', 'font-size', 'opacity', 'border width', can be chain ......
 * @param obj          the html element that want change
 * @param style        the style of element
 * @param value        the value of style
 * @param nextChange   next function of changeStyle to change other attribute
 */
function changeStyle(obj, style, value, nextChange) {
    clearInterval(obj.timer);
    obj.timer = setInterval(function () {
        var currentValue = 0;
        if(style === "opacity"){
            currentValue = parseFloat(getStyle(obj, style)) * 100;
        }else{
            currentValue = parseInt(getStyle(obj, style));
        }
        var speed = (value - currentValue)/6;
        speed = Math.round(speed > 0 ? Math.ceil(speed): Math.floor(speed));
        if (Math.abs(currentValue - value) <= speed) {
            clearInterval(obj.timer);
            if(style === "opacity") {
                obj.style.filter = "alpha(opacity:"+value+")";
                obj.style[style] = value / 100;
            }else{
                obj.style[style] = value + "px";
            }
            if(nextChange) nextChange()
        }else{
            if(style === "opacity") {
                obj.style.filter = "alpha(opacity:"+currentValue + speed+")";
                obj.style[style] = (currentValue + speed) / 100;
            }else{
                obj.style[style] = currentValue + speed + "px";
            }
        }
    }, 30);
}

/**
 * change multi attributes 'width', 'height', 'font-size', 'opacity', 'border width' at same time
 * @param obj          the html element that want change
 * @param styleJson    style json like {attr1: value1, attr2: value2 ...}
 * @param nextChange   next function of changeAttr to change other attribute
 */
function changeMultiStyle(obj, styleJson, nextChange) {
    clearInterval(obj.timer);
    obj.timer = setInterval(function () {
        var stop = true;
        for (var attr in styleJson) {
            var currentValue = 0;
            if (attr === "opacity") {
                currentValue = parseFloat(getStyle(obj, attr)) * 100;
            } else {
                currentValue = parseInt(getStyle(obj, attr));
            }
            var speed = (styleJson[attr] - currentValue) / 6;
            speed = Math.round(speed > 0 ? Math.ceil(speed) : Math.floor(speed));
            if (currentValue !== styleJson[attr]) stop = false;
            if (attr === "opacity") {
                obj.style.filter = "alpha(opacity:" + currentValue + speed + ")";
                obj.style[attr] = (currentValue + speed) / 100;
            } else {
                obj.style[attr] = currentValue + speed + "px";
            }
        }
        if(stop){
            clearInterval(obj.timer);
            if (nextChange) nextChange()
        }
    }, 30);
}

/********************************************************* Ajax *******************************************************/

/**
 * get XMLHttpRequest compatible
 * @returns {*}   XMLHttpRequest object
 */
function getXMLHttpRequest() {
    if(window.XMLHttpRequest){
        //FF, Chrome, IE6 +
        return new XMLHttpRequest();
    }else{
        // IE 6
        return new ActiveXObject("Microsoft.XMLHTTP");
    }
}

/**
 * ajax get request
 * @param url      url <same scope>
 * @param success  success function
 * @param error    error function
 */
function ajax(url, success, error) {
    var ajax = getXMLHttpRequest();
    if(ajax){
        ajax.open('GET', url, true);
        ajax.timeout = 30000; //milliseconds
        ajax.onreadystatechange = function () {
            if (ajax.readyState === 4){ //get data and parse completed
                if(ajax.status === 200){
                    success(ajax.responseText);
                }else{
                    if (error) error(ajax.status);
                }
            }
        };
        ajax.send();
    }
}

/**
 * ajax post request
 * @param url       url <same scope>
 * @param params    request params json format
 * @param success   success function
 * @param error     error function
 */
function ajaxPost(url, params, success, error) {
    var ajax = getXMLHttpRequest();
    if(ajax){
        if(params && isJson(params)) {
            var fromData = new FormData();
            for (var key in params) {
                fromData.append(key, params[key]);
            }
        }
        ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        ajax.open('POST', url, true);
        ajax.timeout = 30000;
        ajax.onreadystatechange = function () {
            if (ajax.readyState === 4){
                if(ajax.status === 200){
                    success(ajax.responseText);
                }else{
                    if (error) error(ajax.status);
                }
            }
        };
        ajax.send(fromData);
    }
}

/********************************************************** utils *****************************************************/

/**
 * put the same type method in a json object, will no problem of create same name
 * @type {{}}
 */
var utils = {};

/**
 * *********************** **** *** ** * network utils
 * @type {{}}
 */
utils.net = {};

utils.net.getIp = function () {

};

/**
 * *********************** **** *** ** * date and time utils
 * @type {{}}
 */
utils.date = {};

/**
 * get current date and time by format 'yyyy-mm-dd hh:mm:ss'
 * @returns {string}
 */
utils.date.getDate = function () {
    var date = new Date();
    return date.getFullYear() + "-" + (date.getMonth()+1) + "-" + date.getDate() + " " +
        date.getHours() + ":" + date.getMinutes()  + ":" + date.getSeconds();
};

/**
 * get current unix time stamp
 * @returns {number}
 */
utils.date.getCurrentMillis = function () {
    return new Date().getTime();
};

/**
 * *********************** **** *** ** * cookie utils
 * @type {{}}
 */
utils.cookie = {};

/**
 * set cookie
 * @param key
 * @param value
 * @param expiresDays
 */
utils.cookie.set = function (key, value, expiresDays) {
    var date = new Date();
    date.setDate(date.getDate() + expiresDays);
    document.cookie = key + "=" + value + "; expires=" + date;
};

/**
 * get cookie by key
 * @param key
 * @returns {*}
 */
utils.cookie.get = function (key) {
    var array = document.cookie.split("; ");
    for(var i = 0 ; i < array.length; i ++){
        var a = array[i].split("=");
        if(a[0] === key){
            return a[1];
        }
    }
    return "";
};

/**
 * remove cookie
 * @param key
 */
utils.cookie.remove = function (key) {
    utils.cookie.set(key, 0, -1);
};

/**
 * check object is json format
 * @param obj
 * @returns {boolean}
 */
function isJson(obj){
    var isjson = typeof(obj) === "object" && Object.prototype.toString.call(obj).toLowerCase() === "[object object]" && !obj.length;
    return isjson;
}