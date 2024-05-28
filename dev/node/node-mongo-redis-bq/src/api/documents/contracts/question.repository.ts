import { Injectable } from '@nestjs/common';
import { IRepository } from 'src/components/base/repository.base';
import { InjectRepository } from '@nestjs/typeorm';
import { MongoRepository } from 'typeorm';
import { QuestionDocument } from '../Question.document';

@Injectable()
export class QuestionRepository implements IRepository<QuestionDocument> {

    constructor(
        @InjectRepository(QuestionDocument) private repository: MongoRepository<QuestionDocument>
    ) {
    }

    findAll(query?: any): Promise<QuestionDocument[]> {
        return this.repository.find(query);
    }

    create(document: QuestionDocument): Promise<QuestionDocument> {
        return this.repository.save(document);
    }

    findById(id: string): Promise<QuestionDocument> {
        return this.repository.findOne({
            where: { _id: id }
        })
    }

    findOne(query: any): Promise<QuestionDocument> {
        return this.repository.findOne({
            where: query
        })
    }

    update(id: string, document: QuestionDocument): Promise<any> {
        return this.repository.update(id, document);

    }

    remove(id: string): Promise<any> {
        return this.repository.delete(id);
    }
} 