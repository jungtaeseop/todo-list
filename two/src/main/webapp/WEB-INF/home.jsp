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
					<input v-model="todoInput" type="text" placeholder="ID">
					<button type="button" class="btn btn-primary btn-sm" v-on:click="todoAddClick">New Todo</button>
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


						<tbody v-if="list">
							<!-- list 있을때  할 일 db 값 출력-->
							<tr v-for="item in list">
								<td>{{item.number}}</td>
								<td>{{item.work}}</td>
								<td>
									<span>{{item.createdDate.split('T')[0]}}</span>
									<span>{{item.createdDate.split('T')[1]}}</span>
								</td>
								<td>
									<span>{{item.modifiedDate.split('T')[0]}}</span>
									<span>{{item.modifiedDate.split('T')[1]}}</span>
								</td>
								<td>{{item.completion}}</td>
							</tr>
						</tbody>

						<tbody v-else>
							<td colspan="5" align="center">등록된 할일이 없습니다.</td>
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


</body>

<script>

	$(function () {    // 아래 있는 함수를  var setVue = function() 사용하는 부분
		setVue();
	});

	var setVue = function () {
		pageVue = new Vue({
			el: '#pageVue',
			data: {
				list: '',
				todoInput: ''
			},
			created: function () {  //화면이 떴을때 실행되는 함수
				this.getWork();
				 
			},
			methods: {
				getWork: function () {
					axios.get('/all', { //all 페이지의 값의 결과를 가져와 home 페이지에 변수값으로 띄어줄수 있음 

						params: {  // get 통신일때만  params 쓴다
							// list : this.list	 값을 백단에 넘길때 쓴다		
						}
					})
						.then(result => {
							console.log('response', result.data) // f12 눌렀을때 console 에 찍는다 response로 시작하고 result.data는 해당 json값만 넘겨준다.
							this.list = result.data;

						})
						.catch(error => {
							//notice(error, false);
						});
				},

				todoAddClick: function () {
					axios.post('/add', {   // post 통신일때 axios.post 씀 
						work: this.todoInput    // work : 파라매타를 db 값에 있는 변수명과 일치 해야됨 
												// this.todoInput 는 화면 입력 값의  변수명
					})
						.then(res => {
							this.todoInput = '';
							this.getWork();
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

</html>