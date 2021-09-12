$(document).ready(function() {
    initProductTable();
});

function initProductTable(){
    let currentState = state;
    let productTable = $('#productTable').DataTable( {
        processing: true,
        stateSave:true,
        //serverSide: true,
        language: {
            sInfoEmpty: "0 Products",
            emptyTable: "No products added yet",
            searchPlaceholder: "Search Products"
        },
        lengthMenu: [[1, 2, 5, -1], [1, 2, 5, 'All']],
        sAjaxSource: "/products/get-products",
        sAjaxDataProp: "",
        order: [[ 0, "asc" ]],
        stateSaveCallback: function (settings, data) {
            let formData = new FormData();
            console.log("Original State Data");
            console.log(data);
            // console.log(JSON.stringify(data));
            formData.append("state", JSON.stringify(data));
            $.ajax({
                url: "/products/state_save",
                data: formData,
                type: "POST",
                processData: false,
                contentType: false,
                success: function (e) {
                    if(e === "success"){
                        console.log("State Saved");
                        state = data;
                    }else{
                        console.log("State Save Error " + e);
                    }
                },
                error: function(e){
                    console.log("State Save Error " + e);
                },
            });
        },
        stateLoadCallback: function (settings) {
            // let state = '';
            // $.ajax( {
            //     url: '/products/state_load',
            //     dataType: 'json',
            //     async: false,
            //     type: "POST",
            //     error: function(response){
            //         console.log("State Load Error " + response);
            //     },
            //     success: function (stateJson) {
            //         console.log("Load Success: ");
            //         console.log(stateJson)
            //         state = stateJson;
            //     }
            // });
            return JSON.parse(state);
        },
        aoColumns: [
            { mData: 'id' },
            { mData: 'name' },
            { mData: 'description' },
            { mData: 'brand' },
            { mData: 'price' },
            { mData: 'units' },
        ],
    });
}