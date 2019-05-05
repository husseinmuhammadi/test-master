function createTable(jsonStr, tableId) {
    var json = $.parseJSON(jsonStr);
    var colCount = 0;
    $.each(json, function (key, value) {
        if (key === "columns") {
            var trA = [];
            var thA = [];
            $.each(value, function (cKey, cValue) {
                colCount = ++colCount;
                thA.push("<th>" + cValue.name + "</th>");
            });

            var trV = $("<tr/>", {"class": "ab", html: thA});
            if ($("#" + tableId).length) {
                trV.appendTo("#" + tableId);
            } else {
                var tableV = $("<table/>", {"id": tableId});
                trV.appendTo(tableV);
                tableV.appendTo("#datatablediv");
            }
        } else if (key === "data") {
            var trA = [];
            var tdA = [];
            $.each(value, function (cKey, cValue) {
                for (i = 0; i < colCount; i++) {
                    tdA.push("<td>" + cValue.values[i] + "</td>");
                }
                var trV = $("<tr/>", {"class": "ab", html: tdA});
                if ($("#" + tableId).length) {
                    trV.appendTo("#" + tableId);
                } else {
                    var tableV = $("<table/>", {"id": tableId});
                    trV.appendTo(tableV);
                    tableV.appendTo("#datatablediv");
                }
                trA = [];
                tdA = [];
            });

        }
    });
}