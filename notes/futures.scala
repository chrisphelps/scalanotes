http://docs.scala-lang.org/overviews/core/futures.html

future function takes the first step and gives the Future[T] result
register callback with onComplete, onSuccess, or onFailure

composing futures: in onSuccess start the new future. not ideal
better is to use for comprehension  (Future is a monad)

example in docs: two futures created before comprehension
for generators for getting the results from the comprehensions
guard to combine the results
result is a future
should be able to create the futures inline in the comprehension
  - in this case, would it mean the second future would not start until
    the first is complete?

put the onSuccess on the future that results from the comprehension
 
