/* ============= Sidebar Sub Menu Start ==================*/

/* Loop through all dropdown buttons to toggle between hiding and showing its dropdown content - This allows the user to have multiple dropdowns without any conflict */
var dropdown = document.getElementsByClassName("dropdown-btn");
var i;

for (i = 0; i < dropdown.length; i++) {
  dropdown[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var dropdownContent = this.nextElementSibling;
    if (dropdownContent.style.display === "block") {
      	dropdownContent.style.display = "none";
    } else {
      	dropdownContent.style.display = "block";
    }
  });
}
/* ============= Sidebar Sub Menu End ==================*/

$(document).ready(function(){

    /*Initialize Searchbox for Student*/
    $("#search_name_student").on("keyup", function() {
          var value = $(this).val().toLowerCase();
          $("#search_data_student tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
          });
    });

    /*Initialize Searchbox for Faculty*/
    $("#search_name_faculty").on("keyup", function() {
          var value = $(this).val().toLowerCase();
          $("#search_data_faculty tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
          });
    });

    /*Initialize Searchbox for Faculty*/
    $("#search_name_staff").on("keyup", function() {
          var value = $(this).val().toLowerCase();
          $("#search_data_staff tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
          });
    });

    /*Initialize Searchbox for Account*/
    $("#search_name_account").on("keyup", function() {
          var value = $(this).val().toLowerCase();
          $("#search_data_account tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
          });
    });

    /*Initialize Searchbox for Fee*/
    $("#search_name_fee").on("keyup", function() {
          var value = $(this).val().toLowerCase();
          $("#search_data_fee tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
          });
    });

     /*Initialize Searchbox for Internship*/
    $("#search_name_intern").on("keyup", function() {
          var value = $(this).val().toLowerCase();
          $("#search_data_intern tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
          });
    });
    
   var myCollapse = document.getElementById('collapseExample')
	var bsCollapse = new bootstrap.Collapse(myCollapse, {
	  toggle: false
	})
    
});

/* ============= Print ID-Card ==================*/
      
      $(function(){
        $('#print').on('click',function(){
          $.print(".id_card");
        });
      });



	/*==================== Show Images in Div ==================*/

			/*======== PP Size Photo ===============*/
		function getImagePreview(event){
			console.log(event.target.files[0]);
			var image = URL.createObjectURL(event.target.files[0]);
			var image_div = document.getElementById('pp_photo');
			var newImage= document.createElement('img');
			image_div.innerHTML='';
			newImage.src=image;
			newImage.width="100";
			image_div.appendChild(newImage);
		}
		
	/*	-------------------------------------------------------------------------- */
		
			/*======== Citizenship Photo ===============*/
		function getImagePreview1(event){
			console.log(event.target.files[0]);
			var image = URL.createObjectURL(event.target.files[0]);
			var image_div = document.getElementById('citizenship');
			var newImage= document.createElement('img');
			newImage.src=image;
			newImage.width="100";
			image_div.appendChild(newImage);
		}

	/*	-------------------------------------------------------------------------- */
		
			/*======== Certificate Photo ===============*/
		function getImagePreview2(event){
			console.log(event.target.files[0]);
			var image = URL.createObjectURL(event.target.files[0]);
			var image_div = document.getElementById('certificate');
			var newImage= document.createElement('img');
			newImage.src=image;
			newImage.width="100";
			image_div.appendChild(newImage);
		}
		
		/*	-------------------------------------------------------------------------- */
		
			/*======== Passport Photo ===============*/
		function getImagePreview3(event){
			console.log(event.target.files[0]);
			var image = URL.createObjectURL(event.target.files[0]);
			var image_div = document.getElementById('passport');
			var newImage= document.createElement('img');
			newImage.src=image;
			newImage.width="100";
			image_div.appendChild(newImage);
		}

		/*	-------------------------------------------------------------------------- */
		
			/*======== Experience Letter Photo ===============*/
		function getImagePreview4(event){
			console.log(event.target.files[0]);
			var image = URL.createObjectURL(event.target.files[0]);
			var image_div = document.getElementById('experience_letter');
			var newImage= document.createElement('img');
			newImage.src=image;
			newImage.width="100";
			image_div.appendChild(newImage);
		}
		
		/*	-------------------------------------------------------------------------- */
		
			/*======== Extra Carriculum Photo ===============*/
		function getImagePreview5(event){
			console.log(event.target.files[0]);
			var image = URL.createObjectURL(event.target.files[0]);
			var image_div = document.getElementById('extra_carriculum');
			var newImage= document.createElement('img');
			newImage.src=image;
			newImage.width="100";
			image_div.appendChild(newImage);
		}
		
	/*	==================================================================================
		==================================================================================*/
		
		/*========================== Student Gallery Section Start  ====================*/
		
		var images = [];
		function img_select(){
			var image = document.getElementById('Image').files;
 			for(i=0; i<image.length; i++){
 				if(check_duplicate(image[i].name)){
					images.push({
						"name" : image[i].name,
						"url" : URL.createObjectURL(image[i]),
						"file" : image[i],
					})
				}else{
					// alert(image[i].name + "is Already Exist");
				}
			}
			document.getElementById('form').reset();
			document.getElementById('container').innerHTML = img_show();
		}
		function img_show(){
			var imag = "";
			images.forEach((i) => {
				imag += `
			<div class="image_container justify-content-center position-relative">
					<img src="`+i.url+`" alt="image">
					<span class="position-absolute" onclick="delete_img(`+images.indexOf(i)+`)">&times;</span>
			</div>`;
			})
			return imag;
		}
		function delete_img(e){
			images.splice(e,1);
			document.getElementById('container').innerHTML = img_show();
		}
		function check_duplicate(name){
			var image = true;
			if(images.length > 0){
				for(j=0; j<images.length; j++){
					if(images[j].name == name){
						image = false;
						break;
					}
				}
			}
			return image;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		