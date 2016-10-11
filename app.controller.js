appMod.controller("AppCtrl", ['$http', '$routeParams', '$location', '$scope', function($http, $routeParams, $location, $scope) {
		var self = this;
		//console.log($routeParams);
		self.id = $routeParams.studentId;

		$http.get('http://localhost:8080/students')
			.then(function(resp){
				self.students = resp.data;
			},function(err) {

			});

if(self.id != undefined) {
		$http.get('http://localhost:8080/student/'+self.id)
			.then(function(resp){
				self.student = resp.data;
			},function(err) {

			});
		}

		self.clear = function(student) {
			student.first_name = "";
			student.last_name = ""
			student.gpa = "";
			student.sat = "";
		};

		self.addclear = function() {
			console.log("IT WORKS");
    $scope.first_name = "";
		$scope.last_name = "";
		$scope.gpa = "";
		$scope.sat = "";
		$scope.majorId = "";

}

		self.addStudent = function(firstName, lastName, sat, gpa, majorId) {
			var stud = {};
			stud.first_name = firstName;
			stud.last_name = lastName;
			stud.sat = sat;
			stud.gpa = gpa;
			stud.major_id = majorId;
			$http({
				method: 'POST',
				url: 'http://localhost:8080/addstudent',
				data: stud
			})
				.then(function(resp) {
					console.log("SUCCESS: ", resp);
				},function(err) {
					console.log("FAILURE: ", resp);
				});
		};

		self.updateStudent = function(id, firstName, lastName, sat, gpa) {
			var stud = {};
			stud.id = id;
			stud.first_name = firstName;
			stud.last_name = lastName;
			stud.sat = sat;
			stud.gpa = gpa;
			$http({
				method: 'PUT',
				url: 'http://localhost:8080/updatestudent',
				data: stud
			})
				.then(function(resp) {
					console.log("SUCCESS: ", resp);
				},function(err) {
					console.log("FAILURE: ", resp);
				});
		};

		self.deleteStudent = function(id) {
			$http.delete('http://localhost:8080/deletestudent/'+id)
				.then(function(resp){
					console.log("SUCCESS: ", resp);
				},function(err) {
					console.log('FAILURE:', resp);
				});

		};

	}]) // end controller


;// end all
