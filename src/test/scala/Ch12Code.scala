import com.philipp.ch12.model.adv.{BasicIntQueue, Doubling, Filtering, Incrementing}
import org.scalatest.FunSuite

class Ch12Code extends FunSuite{
  test("several traits on object") {
    val queue = new BasicIntQueue with Doubling with Incrementing with Filtering
    queue.put(10)
    queue.put(-20)
    queue.put(15)

    assert(queue.get() == 22)
    assertResult(32){
      queue.get()
    }
  }

  test("show how to expect the exception"){
    assertThrows[ArithmeticException] {
      2/0
    }
  }

//  test("falhando de proposito"){
//    assert(List(1,2,3).contains(4))
//  }
}
