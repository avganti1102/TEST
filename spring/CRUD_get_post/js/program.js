$(function() {
    $(".header").load("header.html");
    $(".main").load("home.html");
    $(".footer").load("footer.html");
});

function clickNavHome() {
    $(".main").load("home.html");
}

function clickNavViewListDepartments() {
    $(".main").load("viewlistemployees.html");
    buildTable();
}

var departments = [];

function Department(id, name) {
    this.id = id;
    this.name = name;
}

function getList(){
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/api/v1/departments',
        data: departments,
        success: function(data) { 
            parseData(data);
            fillDepartmentToTable();
            console.log(departments);
        }
    });
}

var sort = "ASC";
var page = 1;

function sortDESC(){
    sort = $('sortDESC').val();
    callAPI();
    sort = "ASC";
}


function callAPI() {
    $('tbody').empty();
    //departments = [];
    var from,to,search;
    from = $('#from').val();
    to = $('#to').val();
    search = $('#search').val();
    var url = new URL("http://localhost:8080/api/v1/departments/");
    if(from != null){
        if(to == null){
            url.searchParams.append("from",from);
            url.searchParams.append("value",search);
            url.searchParams.append("sortType",sort);
            url.searchParams.append("page",page);
            // call API from server
            $.get(url, function(data, status) {

                // reset list employees
                departments = [];

                // error
                if (status == "error") {
                    // TODO
                    alert("Error when loading data");
                    return;
                }

                // success
                parseData(data);
                fillDepartmentToTable(); 
                console.log(url);
            });
        }
    else{
            url.searchParams.append("from",from);
            url.searchParams.append("to",to);
            url.searchParams.append("value",search);
            url.searchParams.append("sortType",sort);
            url.searchParams.append("page",page);
            $.get(url, function(data, status) {

                // reset list employees
                departments = [];
    
                // error
                if (status == "error") {
                    // TODO
                    alert("Error when loading data");
                    return;
                }
    
                // success
                parseData(data);
                fillDepartmentToTable(); 
                console.log(url);
            });
        }
    }
    else{
        from = 1;
        url.searchParams.append("from",from);
        url.searchParams.append("sortType",sort);
        url.searchParams.append("page",page);
            // call API from server
            $.get(url, function(data, status) {

                // reset list employees
                departments = [];

                // error
                if (status == "error") {
                    // TODO
                    alert("Error when loading data");
                    return;
                }

                // success
                parseData(data);
                fillDepartmentToTable(); 
                console.log(url);
            });
    }
}

function parseData(data) {
    departments = data;

    // data.forEach(function(item) {
    //     departments.push(new Department(item.id, item.name));
    // });
}

function fillDepartmentToTable() {
    departments.forEach(function(item) {
        $('tbody').append(
            '<tr>' +
            '<td>' + item.name + '</td>' +
            '<td>' +
            '<a class="edit" title="Edit" data-toggle="tooltip" onclick="openUpdateModal(' + item.id + ')"><i class="material-icons">&#xE254;</i></a>' +
            '<a class="delete" title="Delete" data-toggle="tooltip" onClick="openConfirmDelete(' + item.id + ')"><i class="material-icons">&#xE872;</i></a>' +
            '</td>' +
            '</tr>')
    });
    $('tbody').append(
        '<tr>'+
            '<td></td>' +
            '<td>   <input type="submit" name="previuos" value="<<" onclick="prePage()"> ' +
                '<input type="submit" name="continue" value=">>" onclick="contPage()">' +
        '</tr>'
    );
}

function buildTable() {
    $('tbody').empty();
    getList();
}

function openAddModal() {
    resetForm();
    openModal();
}

function resetForm() {
    document.getElementById("id").value = "";
    document.getElementById("name").value = "";
}

function openModal() {
    $('#myModal').modal('show');
}

function hideModal() {
    $('#myModal').modal('hide');
}

function addDepartment() {

    // get data
    var name = document.getElementById("name").value;

    // TODO validate
    // then fail validate ==> return;

    var department = {
        name: name
    };

    $.ajax({
        url: 'http://localhost:8080/api/v1/departments',
        type: 'POST',
        data: JSON.stringify(department),
        contentType: "application/json",
        success: function(data,textStatus, xhr){
            console.log(data);
            hideModal();
            showSuccessAlert();
            buildTable();
        },
        error(jqXHR, textStatus, errorThrown){
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
}


function openUpdateModal(id) {

    // get index from employee's id
    var index = departments.findIndex(x => x.id == id);

    // fill data
    document.getElementById("id").value = departments[index].id;
    document.getElementById("name").value = departments[index].name;

    openModal();
}

function save() {
    var id = document.getElementById("id").value;

    if (id == null || id == "") {
        addDepartment();
    } else {
        updateDepartment();
    }
}

function updateDepartment() {
    var id = document.getElementById("id").value;
    var name = document.getElementById("name").value;

    // TODO validate
    // then fail validate ==> return;

    var department = {
        name: name
    };

    $.ajax({
        url: 'http://localhost:8080/api/v1/departments/' + id,
        type: 'PUT',
        data: JSON.stringify(department),
        contentType: "application/json",
        success: function(result) {
            // success
            hideModal();
            showSuccessAlert();
            buildTable();
        },
        error(jqXHR, textStatus, errorThrown){
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
}


function openConfirmDelete(id) {
    // get index from employee's id
    var index = departments.findIndex(x => x.id == id);
    var name = departments[index].name;

    var result = confirm("Want to delete " + name + "?");
    if (result) {
        deleteDepartment(id);
    }
}

function deleteDepartment(id) {
    // TODO validate

    $.ajax({
        url: 'http://localhost:8080/api/v1/departments/' + id,
        type: 'DELETE',
        success: function(result) {
            // error
            if (result == undefined || result == null) {
                alert("Error when loading data");
                return;
            }

            // success
            showSuccessAlert();
            buildTable();
        }
    });
}

function showSuccessAlert() {
    $("#success-alert").fadeTo(2000, 500).slideUp(500, function() {
        $("#success-alert").slideUp(500);
    });
}

//                         function sortTable(n) {
//                           var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
//                           table = document.getElementById("myTable");
//                           switching = true;

//                           dir = "asc"; 
//                           /*Make a loop that will continue until
//                           no switching has been done:*/
//                           while (switching) {
//                             //start by saying: no switching is done:
//                             switching = false;
//                             rows = table.rows;
//                             /*Loop through all table rows (except the
//                             first, which contains table headers):*/
//                             for (i = 1; i < (rows.length - 1); i++) {
//                               //start by saying there should be no switching:
//                               shouldSwitch = false;

//                               x = rows[i].getElementsByTagName("TD")[n];
//                               y = rows[i + 1].getElementsByTagName("TD")[n];
                            
//                               if (dir == "asc") {
//                                 if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
//                                   //if so, mark as a switch and break the loop:
//                                   shouldSwitch= true;
//                                   break;
//                                 }
//                               } else if (dir == "desc") {
//                                 if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
//                                   //if so, mark as a switch and break the loop:
//                                   shouldSwitch = true;
//                                   break;
//                                 }
//                               }
//                             }
//                             if (shouldSwitch) {
//                               /*If a switch has been marked, make the switch
//                               and mark that a switch has been done:*/
//                               rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
//                               switching = true;
//                               //Each time a switch is done, increase this count by 1:
//                               switchcount ++;      
//                             } else {
//                               /*If no switching has been done AND the direction is "asc",
//                               set the direction to "desc" and run the while loop again.*/
//                               if (switchcount == 0 && dir == "asc") {
//                                 dir = "desc";
//                                 switching = true;
//                               }
//                             }
//                           }
//                         }

            
// function searchFunction() {
//     var input, filter, table, tr, td, i, txtValue;
//         input = document.getElementById("myInput");
//         filter = input.value.toUpperCase();
//         table = document.getElementById("myTable");
//         tr = table.getElementsByTagName("tr");
//         for (i = 0; i < tr.length; i++) {
//             td = tr[i].getElementsByTagName("td")[0];
//             if (td) {
//             txtValue = td.textContent || td.innerText;
//             if (txtValue.toUpperCase().indexOf(filter) > -1) {
//                 tr[i].style.display = "";
//             } else {
//                 tr[i].style.display = "none";
//             }
//             }       
//         }
//     }
function contPage(){
    if(page > 0 && page <3)
    page++;
    else
    page = page;
    callAPI();
}

function prePage(){
    if(page <= 1)
    page = page;
    else
    page--;
    callAPI();
}