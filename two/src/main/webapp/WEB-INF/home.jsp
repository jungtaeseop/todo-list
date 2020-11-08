<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="include/header.jsp"%>


</head>
<body>
	<div id="pageVue">
		<div class="container mt-5 ">
			<h1>TODO APP</h1>
			<div class="row mt-3">
				<div class="col-auto">
					<input v-model="todoinput" type="text" placeholder="ID">
					<button type="button" class="btn btn-primary btn-sm"
						v-on:click="todoclick">New Todo</button>
				</div>
			</div>


			<div class="row mt-3">
				<!--내용 영역-->
				<div class="col-12">
					<!--목록-->
					<table id="todo_table" class="table table-hover">
						<colgroup>
							<col width="10%" />
							<col width="*" />
							<col width="15%" />
							<col width="15%" />
							<col width="20%" />
						</colgroup>
						<thead class="thead-dark">
							<tr>
								<th>ID</th>
								<th>할일</th>
								<th>작성일시</th>
								<th>최종수정일시</th>
								<th>완료처리</th>
							</tr>
						</thead>
						<tbody id="todo_table_body">
							<tr v-if="list.length < 1">
								<td colspan="5" align="center">등록된 할일이 없습니다.</td>
							</tr>
							<tr v-else>
								<td>{{list}}</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="col-12">
					<ul class="pagination justify-content-center"></ul>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="include/footer.jsp"%>


<script>

	$(function() {
		setVue();
	});
	
	var setVue = function() {		 
		pageVue = new Vue({
			el: '#pageVue',
			data: {
				list: '',
				todoinput: ''
		  	},
			created: function() {
                 this.getItem();
			},
            methods: {
            	todoclick: function() {
					console.log('click')
                },
				getItem: function() {
					axios.get('/api', {
						// get 통신일때만  params 쓰는것 
				        params: {
					       id : this.id			
					    }
					}) 
					.then(result => {
                        //console.log(result)
                        this.list = result.data;
						
	                })
	                .catch(error => {
	                	//notice(error, false);
	                });
				},

				postItem: function() {
					axios.post('/api/item', {
					       id : this.postId,
					       password : this.postPassword,
					       userName : this.postUserName,
					       cellPhone : this.cellPhone,
					       eMail: this.postCellPhone		
					})
					.then(res => {
						this.postname=res.data;
					})
					.catch(error => {
	                	//notice(error, false);
	                });
				}


            }
		});
		
		return pageVue;
	} 
</script>

</body>
</html>