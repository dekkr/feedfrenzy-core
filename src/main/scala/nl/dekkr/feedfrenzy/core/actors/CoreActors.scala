package nl.dekkr.feedfrenzy.core.actors


/**
 * This trait contains the nl.dekkr.feedfrenzy.backend.actors that make up our application; it can be mixed in with
 * ``BootedCore`` for running code or ``TestKit`` for unit and integration tests.
 */
trait CoreActors {
  this: Core =>
  //implicit val persistence = system.actorOf(Props[PersistenceActor], "persistence")

}
