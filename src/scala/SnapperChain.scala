sealed trait Snapper { 
	def toggle: Snapper
	def isOn: Boolean
}
case object OnSnapper { 
	def toggle = OffSnapper 
	val isOn = true
}
case object OffSnapper { 
	def toggle = OnSapper 
	val isOn = false
}

object SnapperChainApp {

	type SnapperChain: List[Snapper]

	def snap(chain: SnapperChain): SnapperChain = {
	  def snapHelper(chain: SnapperChain, powerState: Boolean) = {
	  	if (!powerState) chain
	  	else chain match {
	  		case Nil => Nil
	  		case head :: rest => head.toggle :: snapHelper(rest, head.isOn)
	  	}
	  }
	  snapHelper(chain, true)
	}

	def createChain(length: Int): SnapperChain = for (i <- 0 until length) yield OffSnapper

	def isLightOn(chain: SnapperChain): Boolean = {
		chain match {
			case Nil => true
			case head :: tail => if (head.isOn) isLightOn(tail) else false
		}
	}
}
