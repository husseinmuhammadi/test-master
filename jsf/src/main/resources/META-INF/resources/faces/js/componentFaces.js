function printName(url, width, height, resizable, modal, position) {
    var dialog = $('<div id="dialog-message" title="Important information"></div>').load(url).dialog({
        width: width,
        height: height,
        resizable: resizable,
        modal: modal,
        autoOpen: false,
        position: position,
        buttons: {
            "Close": function () {
                $(this).dialog("close");
            }
        }
    });
    dialog.dialog('open');
    return false;
}

function openDialog(url) {
    BootstrapDialog.show({
        title: 'Dialog',
        message: function (dialog) {
            var $message = $('<div></div>');
            var pageToLoad = dialog.getData('pageToLoad');
            $message.load(pageToLoad);

            return $message;
        },
        closable: true,
        draggable: true,
        closeByBackdrop: false,
        closeByKeyboard: false,
        data: {
            'pageToLoad': url
        }
    });
    return false;
}

function ajaxRequest(urlPage, targetId) {
    $.ajax({
        url: urlPage
    }).done(function (data) {
        $('#' + targetId.toString()).html(data);
    });
}

function match(main, match) {
    var e = document.getElementById(main);
    if (!((e && match) && e.value == match.value)) {
        alert('fff');
    }
}

//http://balusc.omnifaces.org/2011/09/communication-in-jsf-20.html#AjaxRenderingOfContentWhichContainsAnotherForm
/*
jsf.ajax.addOnEvent(function(data) {
    if (data.status == "success") {
        var viewState = getViewState(data.responseXML);

        for (var i = 0; i < document.forms.length; i++) {
            var form = document.forms[i];

            if (form.method == "post" && !hasViewState(form)) {
                createViewState(form, viewState);
            }
        }
    }
});

function getViewState(responseXML) {
    var updates = responseXML.getElementsByTagName("update");

    for (var i = 0; i < updates.length; i++) {
        if (updates[i].getAttribute("id").match(/^([\w]+:)?javax\.faces\.ViewState(:[0-9]+)?$/)) {
            return updates[i].textContent || updates[i].innerText;
        }
    }

    return null;
}

function hasViewState(form) {
    for (var i = 0; i < form.elements.length; i++) {
        if (form.elements[i].name == "javax.faces.ViewState") {
            return true;
        }
    }

    return false;
}

function createViewState(form, viewState) {
    var hidden;

    try {
        hidden = document.createElement("<input name='javax.faces.ViewState'>"); // IE6-8.
    } catch(e) {
        hidden = document.createElement("input");
        hidden.setAttribute("name", "javax.faces.ViewState");
    }

    hidden.setAttribute("type", "hidden");
    hidden.setAttribute("value", viewState);
    hidden.setAttribute("autocomplete", "off");
    form.appendChild(hidden);
}
*/