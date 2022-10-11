<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8'%>
<head>
    <title>hr</title>
    <meta charset='utf-8'>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <script src='https://code.jquery.com/jquery-3.6.0.min.js'></script>
    <script src='https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js'></script>
    <script src='https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js'></script>
    <link rel='stylesheet' href='http://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css' />
    <link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.6.3/css/all.css' />
<script>
function isVal(field) {
    let isGood = false
    let errMsg

    if(!field.length) errMsg = '노동자를 선택하세요.'
    else {
        if(!field.val()) errMsg = field.attr('placeholder') + ' 입력하세요.'
        else isGood = true
    }

    if(!isGood) {
        $('#modalMsg').text(errMsg).css('color', 'red')
        $('#modalBtn').hide()
        $('#modal').modal()
    }

    return isGood
}

function listLaborers() {
    $('input').not(':radio').val('')
    $('#laborers').empty()
    
    $.ajax({
    	url: 'laborer/getLaborers',
    	dataType: 'json',
    	success: laborers => {
    	    if(laborers.length) {
    	        const laborerArr = []

    	        $.each(laborers, (i, laborer) => {
    	            laborerArr.unshift(
    	                `<tr>
    	                    <td><input type='radio' name='laborerId' id='laborerId'
    	                            value='\${laborer.laborerId}'/></td>
    	                    <td>\${laborer.laborerId}</td> 
    	                    <td>\${laborer.laborerName}</td>
    	                    <td>\${laborer.hireDate}</td> // \가 없으면 어트리뷰트로 인식한다. 간단한 텍스트로 만들려고 \를 쓴다.
    	                </tr>`
    	            )
    	        })

    	        $('#laborers').append(laborerArr.join(''))
    	    } else $('#laborers').append(
    	        '<tr><td colspan=4 class=text-center>노동자가 없습니다.</td></tr>')
    	} 
    })
}

function init() {
	listLaborers()
	
	// 노동자 추가
    $('#addLaborerBtn').click(() => {
        if(isVal($('#laborerName')) && isVal($('#hireDate'))) {
            $.ajax({
            	url: 'laborer/addLaborer',
            	method: 'post',
            	data: { // requestbody에 들어가서 핸들러에 전달된다. 평범한 파라미터가 된다.
                    laborerName: $('#laborerName').val(),
                    hireDate: $('#hireDate').val()
                },
            	success: listLaborers
            })
        }
    })
	
    // 노동자 수정
    $('#fixLaborerBtn').click(() => {
        if(isVal($('#laborerId:checked')) &&
            isVal($('#laborerName')) && isVal($('#hireDate'))) {
            
            $.ajax({
            	url: 'laborer/fixLaborer',
            	method: 'put',
            	contentType: 'application/json', // 평범한 파라미터가 아니고 json이라 contentType을 설정 해줘야 한다.
            	data: JSON.stringify({
                	laborerId: $('#laborerId:checked').val(),
                	laborerName: $('#laborerName').val(),
                	hireDate: $('#hireDate').val()
                }),
            	success: listLaborers
            })
        }
    })

    // 노동자 삭제
    $('#delLaborerBtn').click(() => {
        if(isVal($('#laborerId:checked'))) {
            $('#modalMsg').text('노동자를 삭제하시겠습니까?')
            $('#modalBtn').show()
            $('#modal').modal()
        }
    })

    $('#delLaborerOkBtn').click(() => {
        $.ajax({
        	url: 'laborer/delLaborer/' + $('#laborerId:checked').val(),
        	method: 'delete',
        	success: listLaborers
        })
        $('#modal').modal('hide')
    })

    $('#laborers').on({
        change() {
            $('#laborerName').val($(this).parent().next().next().text())
            $('#hireDate').val($(this).parent().next().next().next().text())
        }
    }, '#laborerId')
}

$(init)
</script>
<style>
#hireDate::before {
    content: attr(placeholder);
    width: 100%;
}

#hireDate:focus::before, #hireDate:valid::before {
    display: none;
}
</style>
</head>

<div class='container'>
    <div class='row'>
        <div class='col'>
            <header class='jumbotron p-2'>
                <h1 class='text-center'>HR</h1>
            </header>
        </div>
    </div>
    <div class='row'>
        <div class='col'>
            <form>
                <div class='row mb-3'>
                    <div class='col-2'>
                        <input type='text' class='form-control' placeholder='노동자명' id='laborerName'/>
                    </div>
                    <div class='col-4'>
                        <input type='date' class='form-control' placeholder='입사일' id='hireDate' required/>
                    </div>
                    <div class='col'>
                        <nav class='d-flex'>
                            <button type='button' class='btn btn-success flex-fill mr-1' id='addLaborerBtn'>
                                <i class='fas fa-plus'></i>
                                <sapn class='label d-none d-sm-inline'>추가</sapn>
                            </button>
                            <button type='button' class='btn btn-info flex-fill mr-1' id='fixLaborerBtn'>
                                <i class='fas fa-edit'></i><span class='label d-none d-sm-inline'>수정</span>
                            </button>
                            <button type='button' class='btn btn-warning flex-fill' id='delLaborerBtn'>
                                <i class='fas fa-trash-alt'></i><span class='label d-none d-sm-inline'>삭제</span>
                            </button>
                        </nav>
                    </div>
                </div>
                <div class='row'>
                    <div class='col'>
                        <table class='table'>
                            <thead>
                                <tr><th></th><th>ID</th><th>이름</th><th>입사일</th></tr>
                            </thead>
                            <tbody id='laborers'>
                            </tbody>
                        </table>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<div class='modal fade' tabindex='-1' id='modal'>
    <div class='modal-dialog'>
        <div class='modal-content'>
            <div class='modal-header'>
                <button type='button' class='close' data-dismiss='modal'>
                    <span>&times;</span>
                </button>
            </div>
            <div class='modal-body'>
                <p id='modalMsg'></p>
            </div>
            <div class='modal-footer' id='modalBtn'>
                <button type='button' class='btn btn-secondary' data-dismiss='modal'>아니오</button>
                <button type='button' class='btn btn-primary' id='delLaborerOkBtn'>예</button>
            </div>
        </div>
    </div>
</div>